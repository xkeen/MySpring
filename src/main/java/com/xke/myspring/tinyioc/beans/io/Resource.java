package com.xke.myspring.tinyioc.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource��spring�ڲ���λ��Դ�Ľӿڡ�
 *
 */
public interface Resource {

    public InputStream getInputStream() throws IOException;
}
