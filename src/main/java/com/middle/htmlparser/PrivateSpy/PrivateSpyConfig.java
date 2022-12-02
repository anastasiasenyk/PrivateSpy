//package com.middle.htmlparser.PrivateSpy;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//
//@Configuration
//public class PrivateSpyConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(PrivateSpyRepository repository){
//        return args -> {
//            PrivateSpy spy1 = new PrivateSpy(
//                    1,
//                    "ucu.edu.ua",
//                    "Ukrainian Catholic University",
//                    "Kozelnytska x",
//                    "twitter.com",
//                    "facbook.com",
//                    "logo.png",
//                    "icon.png",
//                    "empoyees500"
//            );
//            PrivateSpy spy2 = new PrivateSpy(
//                    2,
//                    "kpi.kpi.ua",
//                    "KPI",
//                    "Kyiv",
//                    "twitterKpi.com",
//                    "facbookKpi.com",
//                    "logoKpi.png",
//                    "iconKpi.png",
//                    "500"
//            );
//
////            repository.saveAll(
////                    List.of(spy1, spy2)
////            );
//        };
//    }
//}