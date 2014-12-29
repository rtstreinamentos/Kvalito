package br.com.infoglobo.qaTestEngine.ordenador;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;

@Deprecated
public class OrdenadorTestes extends BlockJUnit4ClassRunner  {
	public OrdenadorTestes(Class<?> klass) throws org.junit.runners.model.InitializationError {
        super(klass);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> list = super.computeTestMethods();
        Collections.sort(list, new Comparator<FrameworkMethod>() {
        	public int compare(FrameworkMethod f1, FrameworkMethod f2) {
            	OrdemExecucaoTeste item1 = f1.getAnnotation(OrdemExecucaoTeste.class);
            	OrdemExecucaoTeste item2 = f2.getAnnotation(OrdemExecucaoTeste.class);

                if (item1 == null || item2 == null) {
                    return -1;
                }
                
                return item1.Ordem() - item2.Ordem();
            }
        });
        return list;
    }
}