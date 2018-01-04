package chaptert_20.apt;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Set;

public class InterfaceExtractorProcessor extends AbstractProcessor {

    private ArrayList<Element> elementArrayList = new ArrayList<>();


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return super.getSupportedAnnotationTypes();
    }

    @Override
    public Set<String> getSupportedOptions() {
        return super.getSupportedOptions();
    }


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("开始解析...?");
        try {
            JavaFileObject fileObject = processingEnv.getFiler().createSourceFile("test.txt");
            Writer writer = fileObject.openWriter();
            writer.write("开始解析...?");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Element element : roundEnv.getElementsAnnotatedWith(ExtractInterface.class)) {
            ExtractInterface annotation = element.getAnnotation(ExtractInterface.class);
            System.out.println("开始解析...?");
            //注解为空,跳过解析
            if (annotation == null) {
                break;
            }
            //获取修饰方法为public并且不是static的方法
            if (element.getModifiers().contains(Modifier.PUBLIC)&&!(element.getModifiers().contains(Modifier.STATIC))) {
                elementArrayList.add(element);
            }
            if(elementArrayList.size()>0){
                try {
                    JavaFileObject fileObject = processingEnv.getFiler().createSourceFile(annotation.value());
                    PrintWriter writer = (PrintWriter) fileObject.openWriter();
                    writer.println("package "+element.getSimpleName().toString()+";");
                    writer.println("public interface "+annotation.value()+"{");
                    for (Element m : elementArrayList) {
                        writer.print("  public  ");
                        writer.print(m.asType()+" ");
                        writer.print(m.getSimpleName()+" (");
                        int i=0;
                        VariableElement variableElement = (VariableElement) m;
                        writer.println(variableElement.asType()+" "+variableElement.getSimpleName());
                        if(i++<m.getEnclosedElements().size()){
                            writer.println(", ");
                        }
                        writer.println(");");

                    }
                    writer.println("}");
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }
}
