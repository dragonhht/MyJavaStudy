package com.github.dragonhht.batch.config;

import com.fasterxml.jackson.core.JsonParseException;
import com.github.dragonhht.batch.line.mapper.UserLineMapper;
import com.github.dragonhht.batch.listener.UserItemReaderListener;
import com.github.dragonhht.batch.listener.UserWriterListener;
import com.github.dragonhht.batch.model.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

import javax.persistence.EntityManagerFactory;
import java.io.File;
import java.io.Writer;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-12
 */
public class SaveUserJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    /**
     * 保存用户的Job.
     * @param saveUserStep
     * @return
     */
    @Bean
    public Job saveUserJob(@Qualifier("saveUserStep")Step saveUserStep) {
        // get中的saveUserJob为Job名
        return jobBuilderFactory.get("saveUserJob")
                .start(saveUserStep)
                .build();
    }

    @Bean
    public Step saveUserStep(@Qualifier("jsonUserReader") FlatFileItemReader<User> jsonUserReader,
                             @Qualifier("userItemWriter") JpaItemWriter<User> userItemWriter) {
        return stepBuilderFactory.get("saveUserStep")
                .<User, User>chunk(10)
                .reader(jsonUserReader).faultTolerant().skip(JsonParseException.class).skipLimit(1)
                .listener(new UserItemReaderListener())
                .writer(userItemWriter).faultTolerant().skip(Exception.class).skipLimit(1)
                .listener(new UserWriterListener())
                .build();
    }

    /**
     * 用于从文件中读取User数据.
     * @return
     */
    @Bean
    public FlatFileItemReader<User> jsonUserReader() {
        String filePath = "D:\\my_work_spance\\idea_workspance\\MyJavaStudy\\spring-batch-study\\src\\main\\resources\\resource.txt";
        FlatFileItemReader<User> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(new File(filePath)));
        reader.setLineMapper(new UserLineMapper());
        return reader;
    }

    /**
     * 将User数据写入数据库.
     * @return
     */
    @Bean
    public JpaItemWriter<User> userItemWriter() {
        JpaItemWriter<User> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return writer;
    }

}
