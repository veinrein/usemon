/*
 * Javassist, a Java-bytecode translator toolkit.
 * Copyright (C) 2004 Bill Burke. All Rights Reserved.
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License.  Alternatively, the contents of this file may be used under
 * the terms of the GNU Lesser General Public License Version 2.1 or later.
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 */
package com.usemon.lib.javassist.bytecode.annotation;
import com.usemon.lib.javassist.ClassPool;import com.usemon.lib.javassist.bytecode.ConstPool;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * The value of a member declared in an annotation.
 *
 * @see Annotation#getMemberValue(String)
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 * @author Shigeru Chiba
 */
public abstract class MemberValue {
    ConstPool cp;
    char tag;

    MemberValue(char tag, ConstPool cp) {
        this.cp = cp;
        this.tag = tag;
    }

    /**
     * Returns the value.  If the value type is a primitive type, the
     * returned value is boxed.
     */
    abstract Object getValue(ClassLoader cl, ClassPool cp, Method m)
        throws ClassNotFoundException;

    abstract Class getType(ClassLoader cl) throws ClassNotFoundException;

    static Class loadClass(ClassLoader cl, String classname)
        throws ClassNotFoundException
    {
       return Class.forName(classname, true, cl);
    }

    /**
     * Accepts a visitor.
     */
    public abstract void accept(MemberValueVisitor visitor);

    /**
     * Writes the value.
     */
    public abstract void write(AnnotationsWriter w) throws IOException;
}


