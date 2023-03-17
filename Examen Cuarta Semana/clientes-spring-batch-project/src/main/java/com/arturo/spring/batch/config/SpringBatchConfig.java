package com.arturo.spring.batch.config;

import com.arturo.spring.batch.entity.Cliente;
import com.arturo.spring.batch.repository.ClienteRepository;

import lombok.AllArgsConstructor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

	private JobBuilderFactory jobBuilderFactory;
	private StepBuilderFactory stepBuilderFactory;
	private ClienteRepository clienteRepository;

	@Bean
	public FlatFileItemReader<Cliente> reader() {
		// ITEMREADER PARA OBTENER LOS DATOS DESDE EL CSV EN LOS RECURSOS

		FlatFileItemReader<Cliente> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/clientes.csv"));
		itemReader.setName("csvReader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		return itemReader;
	}

	private LineMapper<Cliente> lineMapper() {
		// METODO DE MAPEO PARA LAS LINEAS DEL CSV

		DefaultLineMapper<Cliente> lineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id", "nombre", "apellido", "correo", "genero", "telefono", "pais", "fecNac");

		BeanWrapperFieldSetMapper<Cliente> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Cliente.class);

		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;

	}

	@Bean
	public ClienteProcessor processor() {
		// METODO QUE DEVUELVE EL ITEMPROCESSOR DEFINIDO EN LA CLASE ClienteProcessor
		return new ClienteProcessor();
	}

	@Bean
	public RepositoryItemWriter<Cliente> writer() {
		// ITEMWRITER QUE ALMACENA LOS REGISTROS EN LA BASE DE DATOS

		RepositoryItemWriter<Cliente> writer = new RepositoryItemWriter<>();
		
		// ASIGNACION AL WITER DEL ClienteRepository PARA PERSISTENCIA Y DE SU METODO SAVE
		writer.setRepository(clienteRepository);
		writer.setMethodName("save");
		return writer;
	}

	@Bean
	public Step step() {
		// EJECUTAR EL PROCESAMIENTO DE REGISTROS DE 10 EN 10

		return stepBuilderFactory.get("csv-step").<Cliente, Cliente>chunk(10).reader(reader()).processor(processor())
				.writer(writer()).taskExecutor(taskExecutor()).build();
	}

	@Bean
	public Job runJob() {
		return jobBuilderFactory.get("importCustomers").flow(step()).end().build();

	}

	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
		asyncTaskExecutor.setConcurrencyLimit(10);
		return asyncTaskExecutor;
	}

}
