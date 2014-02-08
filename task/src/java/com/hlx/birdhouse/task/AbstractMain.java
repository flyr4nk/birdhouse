package com.hlx.birdhouse.task;



public class AbstractMain {
//	private static Logger           log        = LoggerFactory.getLogger(AbstractMain.class);
//    private static final String SERVICE_FILE = "classpath/task/task-services.xml";
//    protected final ServiceManager manager;
//    private final BeanFactoryService beanFactory;
//
//    protected AbstractMain(File basedir, String logfileName) {
//    	System.setProperty("application.codeset","GBK");
//        System.setProperty("database.codeset","ISO-8859-1");
//        // 设置basedir
//        if (basedir == null) {
//            throw new IllegalArgumentException("Basedir is not specified");
//        }
//
//        basedir.mkdirs();
//
//        if (!basedir.isDirectory() || !basedir.exists()) {
//            throw new IllegalArgumentException(
//                "Base directory does not exist: " + basedir);
//        }
//
//        log.info("Set basedir to: " + basedir);
//
//        // 创建bootstrap resource loader service
//        BootstrapResourceLoaderService resourceLoader = new BootstrapResourceLoaderService();
//        resourceLoader.setApplicationRoot(basedir.getAbsolutePath());
//
//        try {
//            DOMConfigurator.configure(resourceLoader.getResourceAsURL(
//            		logfileName));
//        } catch (ResourceNotFoundException e) {
//            throw new RuntimeException("Failed to load log4j configuration", e);
//        }
//
//        // 初始化service manager
//        try {
//            manager = new DefaultServiceManager(resourceLoader, SERVICE_FILE,
//                    true);
//        } catch (ServiceInitializationException e) {
//            throw new RuntimeException("Failed to initialize service manager", e);
//        }
//
//        // 初始化beanFactory
//        beanFactory = (BeanFactoryService) manager.getService(BeanFactoryService.SERVICE_NAME);
//    }
//
//    protected CommandDispatcher getCommandDispatcher() {
//        return (CommandDispatcher) beanFactory.getBean(
//            "commandDispatcherSelector");
//    }
//
//    protected Object getBean(String beanName) {
//    	return beanFactory.getBean(beanName);
//    }
//    
//    public ServiceManager getManager() {
//        return manager;
//    }
//    
//    public void exit(){
//        this.beanFactory.destroy();
//        this.manager.destroy();
//    }
}
