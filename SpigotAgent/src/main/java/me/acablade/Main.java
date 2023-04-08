package me.acablade;

import org.apache.commons.io.IOUtils;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.Remapper;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URISyntaxException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.ProtectionDomain;
import java.util.logging.Logger;

import static org.objectweb.asm.Opcodes.*;
import static org.objectweb.asm.Opcodes.RETURN;

public class Main {




    public static Logger LOGGER = Logger.getLogger("JavaAgent");
    private static boolean initialized;
    private static Instrumentation instrumentation;
    private static String obcVersion, obcClassName;
    private static Path serverJar;

    private final static Remapper remapper = new Remapper() {
        @Override
        public String map(String name) {
            if (!name.startsWith("org/bukkit/craftbukkit/Main") && !name.startsWith("org/bukkit/craftbukkit/libs/") &&
                    name.startsWith("org/bukkit/craftbukkit/") && !name.startsWith("org/bukkit/craftbukkit/v1_")) {
                if (obcVersion == null) throw new IllegalStateException("Cannot detect minecraft version!");
                return obcClassName + name.substring(23);
            }
            return super.map(name);
        }
    };

    private final static class Transformer implements ClassFileTransformer {

        private byte[] materialClass;

        public Transformer(){
            try {
                InputStream is = getClass().getClassLoader().getResourceAsStream("Material.class");
                byte[] bytes = IOUtils.toByteArray(is);
                materialClass = bytes;
            } catch (IOException e) {
                materialClass = new byte[]{};
                throw new RuntimeException(e);
            }
        }

        private File getFileFromResource(String fileName) throws URISyntaxException{

            ClassLoader classLoader = getClass().getClassLoader();
            URL resource = classLoader.getResource(fileName);
            if (resource == null) {
                throw new IllegalArgumentException("file not found! " + fileName);
            } else {

                // failed if files have whitespaces or special characters
                //return new File(resource.getFile());

                return new File(resource.toURI());
            }

        }

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                                ProtectionDomain protectionDomain, byte[] data) {

            ClassReader cr = new ClassReader(data);
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);

            if("org/bukkit/Material".equals(className)) {
                LOGGER.info("---- found Material ----");

                return this.materialClass;

//                return MaterialTransformer.dump();


//                FieldVisitor fieldVisitor = cw.visitField(ACC_PUBLIC | ACC_FINAL | ACC_STATIC | ACC_ENUM, "GOKYUZU_MAVI_KILIC", "Lorg/bukkit/Material;", null, null);
//                fieldVisitor.visitEnd();
//
//                cr.accept(new ClassVisitor(Opcodes.ASM9, cw) {
//
//                    @Override
//                    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
//                        MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
//                        return name.equals("$values") ? new MethodVisitor(Opcodes.ASM9) {
//                            @Override
//                            public void visitCode() {
//                                super.visitCode();
//
//                            }
//                        } : methodVisitor;
//                    }
//                }, ClassReader.EXPAND_FRAMES);
//                return cw.toByteArray();
            }
            if (!initialized) return data;
            return null;
        }
    }





    public static void log(){
        for(StackTraceElement[] elements: Thread.getAllStackTraces().values()){
            for (int i = 0; i < elements.length; i++) {
                Main.LOGGER.info(elements[i].getClassName() +" --> "+elements[i].getMethodName());

            }
        }
        Main.LOGGER.info("------------");
    }

    private static void initPaperShelled(Instrumentation instrumentation) {
        Package pkg = Main.class.getPackage();
        LOGGER.info(pkg.getImplementationTitle() + " version: " + pkg.getImplementationVersion() +
                " (" + pkg.getImplementationVendor() + ")");
        System.setProperty("mixin.env.remapRefMap", "true");
        Main.instrumentation = instrumentation;
        instrumentation.addTransformer(new Transformer(), true);
        System.setProperty("papershelled.enable", "true");
    }

    public static void premain(String arg, Instrumentation instrumentation) {
        System.setProperty("mixin.hotSwap", "true");
        initPaperShelled(instrumentation);
    }

    public static void agentmain(String arg, Instrumentation instrumentation) {
        initPaperShelled(instrumentation);
    }
}