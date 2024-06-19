package com.patrones.factory;

import java.util.HashMap;
import java.util.Map;

import com.google.common.reflect.ClassPath;
import com.patrones.factory.anotaciones.MiComponente;

public class FactoryImpl implements Factory {

	/*
	 * ("laptop", laptopComputadora.class)
	 */
	
	
	private Map<String, Class> componentes = new HashMap<String, Class>();
	private Map<String, Object> singleton = new HashMap<String, Object>();

	public void init(String pkgName) {
		try {
			//System.out.println();
			//System.out.println("Listar clases");
			ClassPath classPath = ClassPath.from(FactoryImpl.class.getClassLoader()); // acceso al classpath

			// ImmutableSet<ClassInfo>
			//var classes = classPath.getTopLevelClassesRecursive("com.patrones.factory");
			var classes = classPath.getTopLevelClassesRecursive(pkgName);

			for (var it : classes) {
				var miComp = it.load().getAnnotation(MiComponente.class);
				if (miComp != null) {
					// String name = it.getName();
					// System.out.println(name);
					var cls = it.load();
					componentes.put(miComp.name(), cls);
					if(miComp.singleton()) {
						//registrar en el map ´singleton´
						var cto = cls.getConstructor();
						Object obj = cto.newInstance();
						singleton.put(miComp.name(), obj);
					}
					
				}
			}
			
			//for (var it : componentes.entrySet()) {
			//	System.out.printf("%s-->%s\n", it.getKey(), it.getValue());
			//}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public <T> T create(String name) {
		if(singleton.containsKey(name)) {
			return (T) singleton.get(name);
		}

		var value = componentes.get(name);

		if (value == null) {
			throw new RuntimeException("Componente " + name + " no registrado.");
		}

		try {
			var cto = value.getConstructor();
			Object obj = cto.newInstance();
			
			return (T )obj;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

//		Object ret = null;
//
//		if (name.equals("pc")) {
//			ret = new PcComputadora();
//		} else if (name.equals("server")) {
//			ret = new ServerComputadora();
//		} else if (name.equals("laptop")) {
//			ret = new LaptopComputadora();
//		}
//
//		return (T) ret;
	}

}

