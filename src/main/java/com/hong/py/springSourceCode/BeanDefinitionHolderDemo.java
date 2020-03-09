package com.hong.py.springSourceCode;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;

public class BeanDefinitionHolderDemo {

    public static void main(String[] args) {

       /* ClassPathResource resource=new ClassPathResource("applicationContext.xml");
        XmlBeanFactory xmlbeanFactory = new XmlBeanFactory(resource);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(xmlbeanFactory);
        DocumentLoader documentLoader = new DefaultDocumentLoader();
        EncodedResource encodedResource = new EncodedResource(resource);

        try {
            InputStream inputStream = encodedResource.getResource().getInputStream();
            try {
                InputSource inputSource = new InputSource(inputStream);
                if (encodedResource.getEncoding() != null) {
                    inputSource.setEncoding(encodedResource.getEncoding());
                }
                Document doc = documentLoader.loadDocument(inputSource, reader.getEntityResolver(), reader.errorHandler,
                        reader.getValidationModeForResource(resource), reader.isNamespaceAware());
            }
            finally {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        XmlReaderContext readerContext=new XmlReaderContext(encodedResource.getResource(), reader.problemReporter, reader.eventListener,
                reader.sourceExtractor, reader, reader.getNamespaceHandlerResolver());

        BeanDefinitionParserDelegate delegate = new BeanDefinitionParserDelegate(readerContext);*/



    }
}
