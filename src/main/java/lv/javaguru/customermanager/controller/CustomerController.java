package lv.javaguru.customermanager.controller;

import lv.javaguru.customermanager.model.Customer;
import lv.javaguru.customermanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    private CustomerService customerService;

    @Autowired(required = true)
    @Qualifier(value = "customerService")
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String listCustomers(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("listCustomers", this.customerService.listCustomers());
        return "/customers";
    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer){
        if(customer.getId() == 0){
            this.customerService.addCustomer(customer);
        }else {
            this.customerService.updateCustomer(customer);
        }
        return "redirect:/customers";
    }

    @RequestMapping("/remove/{id}")
    public String removeCustomer(@PathVariable("id") int id){
        this.customerService.removeCustomer(id);
        return "redirect:/customers";
    }


    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", this.customerService.getCustomerById(id));
        model.addAttribute("listCustomers", this.customerService.listCustomers());
        return "customers";
    }

    @RequestMapping("customerdata/{id}")
    public String customerData(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", this.customerService.getCustomerById(id));
        return "customerdata";
    }
}

/*
C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82\bin\catalina.bat run
        [2017-12-03 04:41:19,689] Artifact CustomerManager:war: Waiting for server connection to start artifact deployment...
        Using CATALINA_BASE:   "C:\Users\Oleg\.IntelliJIdea2017.2\system\tomcat\Tomcat_8_0_32_CustomerManager"
        Using CATALINA_HOME:   "C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82"
        Using CATALINA_TMPDIR: "C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82\temp"
        Using JRE_HOME:        "C:\Program Files\Java\jdk1.8.0_144"
        Using CLASSPATH:       "C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82\bin\bootstrap.jar;C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82\bin\tomcat-juli.jar"
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Server version:        Apache Tomcat/7.0.82
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Server built:          Sep 29 2017 12:23:15 UTC
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Server number:         7.0.82.0
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: OS Name:               Windows 8.1
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: OS Version:            6.3
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Architecture:          amd64
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Java Home:             C:\Program Files\Java\jdk1.8.0_144\jre
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: JVM Version:           1.8.0_144-b01
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: JVM Vendor:            Oracle Corporation
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: CATALINA_BASE:         C:\Users\Oleg\.IntelliJIdea2017.2\system\tomcat\Tomcat_8_0_32_CustomerManager
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: CATALINA_HOME:         C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Command line argument: -Djava.util.logging.config.file=C:\Users\Oleg\.IntelliJIdea2017.2\system\tomcat\Tomcat_8_0_32_CustomerManager\conf\logging.properties
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Command line argument: -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Command line argument: -Dcom.sun.management.jmxremote=
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Command line argument: -Dcom.sun.management.jmxremote.port=1099
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Command line argument: -Dcom.sun.management.jmxremote.ssl=false
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Command line argument: -Dcom.sun.management.jmxremote.authenticate=false
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Command line argument: -Djava.rmi.server.hostname=127.0.0.1
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Command line argument: -Djdk.tls.ephemeralDHKeySize=2048
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Command line argument: -Djava.endorsed.dirs=C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82\endorsed
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Command line argument: -Dcatalina.base=C:\Users\Oleg\.IntelliJIdea2017.2\system\tomcat\Tomcat_8_0_32_CustomerManager
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Command line argument: -Dcatalina.home=C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82
        ??? 03, 2017 4:41:20 PM org.apache.catalina.startup.VersionLoggerListener log
        INFO: Command line argument: -Djava.io.tmpdir=C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82\temp
        ??? 03, 2017 4:41:20 PM org.apache.catalina.core.AprLifecycleListener lifecycleEvent
        INFO: Loaded APR based Apache Tomcat Native library 1.2.14 using APR version 1.6.2.
        ??? 03, 2017 4:41:20 PM org.apache.catalina.core.AprLifecycleListener lifecycleEvent
        INFO: APR capabilities: IPv6 [true], sendfile [true], accept filters [false], random [true].
        ??? 03, 2017 4:41:21 PM org.apache.catalina.core.AprLifecycleListener initializeSSL
        INFO: OpenSSL successfully initialized (OpenSSL 1.0.2l  25 May 2017)
        ??? 03, 2017 4:41:21 PM org.apache.coyote.AbstractProtocol init
        INFO: Initializing ProtocolHandler ["http-apr-8080"]
        ??? 03, 2017 4:41:21 PM org.apache.coyote.AbstractProtocol init
        INFO: Initializing ProtocolHandler ["ajp-apr-8009"]
        ??? 03, 2017 4:41:21 PM org.apache.catalina.startup.Catalina load
        INFO: Initialization processed in 1535 ms
        ??? 03, 2017 4:41:21 PM org.apache.catalina.core.StandardService startInternal
        INFO: Starting service Catalina
        ??? 03, 2017 4:41:21 PM org.apache.catalina.core.StandardEngine startInternal
        INFO: Starting Servlet Engine: Apache Tomcat/7.0.82
        ??? 03, 2017 4:41:21 PM org.apache.coyote.AbstractProtocol start
        INFO: Starting ProtocolHandler ["http-apr-8080"]
        ??? 03, 2017 4:41:21 PM org.apache.coyote.AbstractProtocol start
        INFO: Starting ProtocolHandler ["ajp-apr-8009"]
        ??? 03, 2017 4:41:21 PM org.apache.catalina.startup.Catalina start
        INFO: Server startup in 115 ms
        Connected to server
        [2017-12-03 04:41:22,301] Artifact CustomerManager:war: Artifact is being deployed, please wait...
        ??? 03, 2017 4:41:24 PM org.apache.catalina.startup.TldConfig execute
        INFO: At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
        log4j:WARN No appenders could be found for logger (org.springframework.web.servlet.DispatcherServlet).
        log4j:WARN Please initialize the log4j system properly.
        [2017-12-03 04:41:28,213] Artifact CustomerManager:war: Artifact is deployed successfully
        [2017-12-03 04:41:28,213] Artifact CustomerManager:war: Deploy took 5 912 milliseconds
        ??? 03, 2017 4:41:28 PM org.apache.jasper.compiler.TldLocationsCache tldScanJar
        INFO: At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
        ??? 03, 2017 4:41:31 PM org.apache.catalina.startup.HostConfig deployDirectory
        INFO: Deploying web application directory C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82\webapps\manager
        ??? 03, 2017 4:41:31 PM org.apache.catalina.startup.HostConfig deployDirectory
        INFO: Deployment of web application directory C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82\webapps\manager has finished in 80 ms
        Hibernate: select customer0_.ID as ID1_0_, customer0_.ADDRESS as ADDRESS2_0_, customer0_.EMAIL as EMAIL3_0_, customer0_.NAME as NAME4_0_, customer0_.REG_NR as REG_NR5_0_ from customer customer0_
        Hibernate: select customer0_.ID as ID1_0_0_, customer0_.ADDRESS as ADDRESS2_0_0_, customer0_.EMAIL as EMAIL3_0_0_, customer0_.NAME as NAME4_0_0_, customer0_.REG_NR as REG_NR5_0_0_ from customer customer0_ where customer0_.ID=?
        Hibernate: delete from customer where ID=?
        Hibernate: select customer0_.ID as ID1_0_, customer0_.ADDRESS as ADDRESS2_0_, customer0_.EMAIL as EMAIL3_0_, customer0_.NAME as NAME4_0_, customer0_.REG_NR as REG_NR5_0_ from customer customer0_
        Hibernate: select customer0_.ID as ID1_0_0_, customer0_.ADDRESS as ADDRESS2_0_0_, customer0_.EMAIL as EMAIL3_0_0_, customer0_.NAME as NAME4_0_0_, customer0_.REG_NR as REG_NR5_0_0_ from customer customer0_ where customer0_.ID=?
        Hibernate: select customer0_.ID as ID1_0_, customer0_.ADDRESS as ADDRESS2_0_, customer0_.EMAIL as EMAIL3_0_, customer0_.NAME as NAME4_0_, customer0_.REG_NR as REG_NR5_0_ from customer customer0_
        Hibernate: update customer set ADDRESS=?, EMAIL=?, NAME=?, REG_NR=? where ID=?
        Hibernate: select customer0_.ID as ID1_0_, customer0_.ADDRESS as ADDRESS2_0_, customer0_.EMAIL as EMAIL3_0_, customer0_.NAME as NAME4_0_, customer0_.REG_NR as REG_NR5_0_ from customer customer0_
        Hibernate: insert into customer (ADDRESS, EMAIL, NAME, REG_NR) values (?, ?, ?, ?)
        Hibernate: select customer0_.ID as ID1_0_, customer0_.ADDRESS as ADDRESS2_0_, customer0_.EMAIL as EMAIL3_0_, customer0_.NAME as NAME4_0_, customer0_.REG_NR as REG_NR5_0_ from customer customer0_
        Hibernate: select customer0_.ID as ID1_0_0_, customer0_.ADDRESS as ADDRESS2_0_0_, customer0_.EMAIL as EMAIL3_0_0_, customer0_.NAME as NAME4_0_0_, customer0_.REG_NR as REG_NR5_0_0_ from customer customer0_ where customer0_.ID=?
        Hibernate: select customer0_.ID as ID1_0_, customer0_.ADDRESS as ADDRESS2_0_, customer0_.EMAIL as EMAIL3_0_, customer0_.NAME as NAME4_0_, customer0_.REG_NR as REG_NR5_0_ from customer customer0_
        C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82\bin\catalina.bat stop
        Using CATALINA_BASE:   "C:\Users\Oleg\.IntelliJIdea2017.2\system\tomcat\Tomcat_8_0_32_CustomerManager"
        Using CATALINA_HOME:   "C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82"
        Using CATALINA_TMPDIR: "C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82\temp"
        Using JRE_HOME:        "C:\Program Files\Java\jdk1.8.0_144"
        Using CLASSPATH:       "C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82\bin\bootstrap.jar;C:\Users\Oleg\Tomcat\apache-tomcat-7.0.82\bin\tomcat-juli.jar"
        ??? 03, 2017 4:42:45 PM org.apache.catalina.core.StandardServer await
        INFO: A valid shutdown command was received via the shutdown port. Stopping the Server instance.
        ??? 03, 2017 4:42:45 PM org.apache.coyote.AbstractProtocol pause
        INFO: Pausing ProtocolHandler ["http-apr-8080"]
        ??? 03, 2017 4:42:45 PM org.apache.coyote.AbstractProtocol pause
        INFO: Pausing ProtocolHandler ["ajp-apr-8009"]
        ??? 03, 2017 4:42:45 PM org.apache.catalina.core.StandardService stopInternal
        INFO: Stopping service Catalina
        ??? 03, 2017 4:42:45 PM org.apache.catalina.loader.WebappClassLoaderBase clearReferencesJdbc
        SEVERE: The web application [] registered the JDBC driver [com.mysql.jdbc.Driver] but failed to unregister it when the web application was stopped. To prevent a memory leak, the JDBC Driver has been forcibly unregistered.
        ??? 03, 2017 4:42:45 PM org.apache.coyote.AbstractProtocol stop
        INFO: Stopping ProtocolHandler ["http-apr-8080"]
        ??? 03, 2017 4:42:45 PM org.apache.coyote.AbstractProtocol stop
        INFO: Stopping ProtocolHandler ["ajp-apr-8009"]
        ??? 03, 2017 4:42:45 PM org.apache.coyote.AbstractProtocol destroy
        INFO: Destroying ProtocolHandler ["http-apr-8080"]
        ??? 03, 2017 4:42:45 PM org.apache.coyote.AbstractProtocol destroy
        INFO: Destroying ProtocolHandler ["ajp-apr-8009"]
        Disconnected from server
*/