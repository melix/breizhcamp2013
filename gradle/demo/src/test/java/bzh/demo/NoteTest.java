/*
 * Copyright 2003-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package bzh.demo;

import org.junit.Test;
import static org.junit.Assert.*;

public class NoteTest {

    @Test
    public void testGetAuthor() throws Exception {
        Note note = new Note("Cédric", "Hello", "Breizhcamp");
        assertEquals(note.getAuthor(), "Cédric");
    }

    @Test
    public void testGetTitle() throws Exception {
        Note note = new Note("Cédric", "Hello", "Breizhcamp");
        assertEquals(note.getTitle(), "Hello");
    }

    @Test
    public void testGetText() throws Exception {
        Note note = new Note("Cédric", "Hello", "Breizhcamp");
        assertEquals(note.getText(), "Breizhcamp");
    }
}
