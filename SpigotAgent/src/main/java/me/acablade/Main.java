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


        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                                ProtectionDomain protectionDomain, byte[] data) {

            ClassReader cr = new ClassReader(data);
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);

            if("org/bukkit/Material".equals(className)) {
                LOGGER.info("---- found Material ----");

                return this.materialClass;
            }
            else if("org/bukkit/plugin/messaging/StandardMessenger".equals(className)){

                LOGGER.info("---- found StandardMessenger ----");

                cr.accept(new ClassVisitor(Opcodes.ASM9, cw) {
                    @Override
                    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                        MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
                        return name.equals("validateChannel") ? new MethodVisitor(Opcodes.ASM9) {
                            @Override
                            public void visitCode() {
                                Label label0 = new Label();
                                methodVisitor.visitLabel(label0);
                                methodVisitor.visitLineNumber(8, label0);
                                methodVisitor.visitVarInsn(ALOAD, 0);
                                Label label1 = new Label();
                                methodVisitor.visitJumpInsn(IFNONNULL, label1);
                                Label label2 = new Label();
                                methodVisitor.visitLabel(label2);
                                methodVisitor.visitLineNumber(9, label2);
                                methodVisitor.visitTypeInsn(NEW, "java/lang/IllegalArgumentException");
                                methodVisitor.visitInsn(DUP);
                                methodVisitor.visitLdcInsn("Channel cannot be null");
                                methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V", false);
                                methodVisitor.visitInsn(ATHROW);
                                methodVisitor.visitLabel(label1);
                                methodVisitor.visitLineNumber(10, label1);
                                methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
                                methodVisitor.visitInsn(RETURN);
                                Label label3 = new Label();
                                methodVisitor.visitLabel(label3);
                                methodVisitor.visitLocalVariable("channel", "Ljava/lang/String;", null, label0, label3, 0);
                                methodVisitor.visitMaxs(3, 1);
                                methodVisitor.visitEnd();

                            }
                        } : methodVisitor;
                    }
                }, ClassReader.EXPAND_FRAMES);
                return cw.toByteArray();
            }

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
            return data;
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