/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.java;

import java.util.regex.Matcher;

import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.execution.FileHelper_to_be_upgraded;

/**
 * @author Thomas Guiu
 */

public class JavaNatureHelper {
    private static final java.util.regex.Pattern compile = java.util.regex.Pattern.compile(".*package\\s*([\\w\\.]*).*class\\s*([\\w]*).*", java.util.regex.Pattern.DOTALL | java.util.regex.Pattern.MULTILINE);

    /**
     * This method parses the template header to know the template class name.
     * 
     * @return never returns null or empty string.
     */
    public static String getClassName(Pattern pattern) throws PatternException {
        try {
            String content = FileHelper_to_be_upgraded.getContent(PatternHelper.getPlatformFcore(pattern), pattern.getHeaderMethod().getPatternFilePath());
            Matcher matcher = compile.matcher(content);
            if (matcher.matches()) {
                String pack = matcher.group(1);
                String cls = matcher.group(2);
                if ("".equals(pack) || "".equals(cls))
                    throw new PatternException(Messages.bind(Messages.assembly_error8, pattern.getName()));
                return pack + "." + cls;
            }
        } catch (PatternException e) {
            throw e;
        } catch (Exception e) {
            throw new PatternException(e);
        }
        throw new PatternException(Messages.bind(Messages.assembly_error6, pattern.getName()));
    }

    private JavaNatureHelper() {
    }
}
