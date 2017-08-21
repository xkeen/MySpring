package com.xke.myspring.tinyioc.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource是spring内部定位资源的接口。
 *
 */
public interface Resource {

    public InputStream getInputStream() throws IOException;
}
