package com.ls.juc.functioninterface;

import javax.xml.bind.SchemaOutputResolver;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionDemo {
    public static void main(String[] args) {

    }

    /**
     * Function   <T,R></>
     * 输入T   相应R
     */
    /*Function<String,String> function=new Function<String, String>() {
        @Override
        public String apply(String s) {
            return s;
        }
    };*/

    Function<String, String> function = str -> {
        return str;
    };
    /**
     * 判断型
     * Predecate <T></>
     * 输入T  相应  bealoon
     */

    /*Predicate<String> predicate=new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return false;
        }
    };*/
    Predicate<String> predicate = str -> {
        if (str.isEmpty()) {
            return true;
        }
        return false;
    };

    /**
     * 消费型接口  只有参数  没有返回值
     */
   /* Consumer<String >consumer=new Consumer<String>() {
        @Override
        public void accept(String s) {
            System.out.println("sjhsjsjsj");
        }
    };*/

    Consumer <String> consumer=s -> {
        System.out.println("hsdjhdjdj");
    };
    /**
     * 供给型  只返回 不要参数
     */

    /*Supplier  supplier=new Supplier<String>() {
        @Override
        public String get() {
            return "1024";
        }
    };*/

    Supplier supplier=()->{
        return 5555;
    };
}
