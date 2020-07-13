package com.ttac.servicesimpledemo.spring;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringMvcTest  {

    @Autowired
    private HttpMessageConverters httpMessageConverters;


    /**
     * implements WebMvcConfigurer
     */
    class springHttpMessageConvertTest implements WebMvcConfigurer {
        @Override
        public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

            converters.forEach(c->log.info(c.getSupportedMediaTypes().toString()));
        }


    }

    /**
     *  implements HttpMessageConverter
     */
    class springHttpMessageConvertTest1 implements HttpMessageConverter{

        @Override
        public boolean canRead(Class aClass, MediaType mediaType) {
            return false;
        }

        @Override
        public boolean canWrite(Class aClass, MediaType mediaType) {
            return false;
        }

        @Override
        public List<MediaType> getSupportedMediaTypes() {
            return null;
        }

        @Override
        public Object read(Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
            return null;
        }

        @Override
        public void write(Object o, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

        }
    }

    class springHttpMessageConvertTest2 extends AbstractHttpMessageConverter{

        @Override
        protected boolean supports(Class aClass) {
            return false;
        }

        @Override
        protected Object readInternal(Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
            return null;
        }

        @Override
        protected void writeInternal(Object o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

        }
    }



    @Test
    public void deets(){
        List<HttpMessageConverter<?>> converters = httpMessageConverters.getConverters();
        Iterator<HttpMessageConverter<?>> iterator = converters.iterator();
        while (iterator.hasNext()){
            HttpMessageConverter<?> next = iterator.next();
            log.info("name:{}", next);
            List<MediaType> types = next.getSupportedMediaTypes();
            types.forEach(c->log.info("typeName:{}", c.getType()));
        }
    }
}
