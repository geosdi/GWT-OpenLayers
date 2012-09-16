/*
 * Copyright 2012 sourceforge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtopenmaps.openlayers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Simple example that creates each time you run the Public Folder containing
 * txt files of each Sample </p>
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class CodeGeneratorTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //
    private static final String EXAMPLES_DIR = "src/main/java/org/gwtopenmaps"
            + "/demo/openlayers/client/examples/";
    private static final String EXAMPLES_PUBLIC_DIR = "src/main/resources/org/"
            + "gwtopenmaps/demo/openlayers/public/examples/";

    @Before
    public void setup() {
        logger.info("@@@@@@@@ Gwt Openlayers Generation Source Code Start.");
    }

    @After
    public void tearDown() {
        logger.info("@@@@@@@@ Gwt Openlayers Generation Source Code Stop.");
    }

    @Test
    public void generateSourceCode() {
        File folder = new File(EXAMPLES_DIR);
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                scanFolder(file);
            }
        }
    }

    private void scanFolder(File folder) {
        for (File file : folder.listFiles()) {
            if (!file.isDirectory() && file.getName().endsWith(".java")) {
                createFile(file, EXAMPLES_PUBLIC_DIR + folder.getName() + "/");
            }
        }
    }

    private void createFile(File file, String folder) {
        try {
            String javaCode = new String(read(new FileInputStream(file)));

            /**
             * Change File sufffix in .txt *
             */
            String fileName = file.getName().substring(0, file.getName()
                    .length() - 4) + "txt";
            File publicSourceFile = new File(folder + fileName);
            File folderFile = new File(folder);
            folderFile.mkdir();
            FileOutputStream out = new FileOutputStream(publicSourceFile);
            out.write(javaCode.getBytes());
            out.flush();
            out.close();

        } catch (FileNotFoundException es) {
            logger.error("FileNotFoundException : " + es);
        } catch (IOException ex) {
            logger.error("IOException :" + ex);
        }

    }

    private byte[] read(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream(32768);
        byte[] buffer = new byte[1024];
        int count = in.read(buffer);
        while (count != -1) {
            if (count != 0) {
                out.write(buffer, 0, count);
            }
            count = in.read(buffer);
        }
        in.close();
        return out.toByteArray();
    }
}
