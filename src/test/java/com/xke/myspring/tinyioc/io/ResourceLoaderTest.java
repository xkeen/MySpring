package com.xke.myspring.tinyioc.io;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import com.xke.myspring.tinyioc.beans.io.Resource;
import com.xke.myspring.tinyioc.beans.io.ResourceLoader;



public class ResourceLoaderTest {
	
	@Test
	public void test() throws IOException {
		ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("tinyioc.xml");
        InputStream inputStream = resource.getInputStream();
        byte[] b = new byte[10];
		inputStream.read(b);
		System.out.println(new String(b));
        Assert.assertNotNull(inputStream);
    }
	
}
