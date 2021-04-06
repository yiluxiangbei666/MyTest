package subejct;


import com.subject.Student;
import jdk.nashorn.api.tree.Tree;
import org.junit.Test;
import com.subject.*;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Demo {
    @Test
    public void TestMultiplication() {
        List<Student> list = Arrays.asList(
                new Student("九天", "男", 5000, 18, "天秤座"),
                new Student("九天", "男", 5000, 18, "天秤座"),
                new Student("九天", "男", 5000, 18, "天秤座"),
                new Student("十夜", "男", 4000, 16, "双鱼座"),
                new Student("十一郎", "男", 3000, 24, "水瓶座")
        );
//       list.stream().filter((e) -> e.getStar().equals("天秤座"))
//                .forEach(System.out::print);
        list.stream().map(Student::getName).forEach(System.out::println);

        String[] array = {"HELLO", "WORLD"};
        Object[] objects = Arrays.stream(array).toArray();
        Arrays.stream(objects).forEach(System.out::println);
        List<String> strings = Arrays.asList("hello", "world");
        List<String[]> collect = strings.stream().map(w -> w.split("")).collect(Collectors.toList());
        List<Stream<String>> collect1 = collect.stream().map(array1 -> Arrays.stream(array1)).collect(Collectors.toList());
        collect1.stream().forEach(d -> {
            d.forEach(System.out::println);
        });

        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Integer> integers1 = Arrays.asList(3, 4);
        List<int[]> collect3 = integers.stream().flatMap(i -> integers1.stream()
                .map(j -> new int[]{i, j})).collect(Collectors.toList());
        System.out.println(collect3);

        System.out.println("***************************");
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});

        //求集合元素只和
        Integer result = stream.reduce(0, Integer::sum);
        System.out.println(result);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        //求和
        stream.reduce((i, j) -> i + j).ifPresent(System.out::println);


        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //求最大值
        stream.reduce(Integer::max).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //求最小值
        stream.reduce(Integer::min).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //做逻辑
        stream.reduce((i, j) -> i > j ? j : i).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        //求逻辑求乘机
        int result2 = stream.filter(i -> i % 2 == 0).reduce(1, (i, j) -> i * j);

        Optional.of(result2).ifPresent(System.out::println);
    }

    private static List<Dish> menu = Arrays.asList(
            new Dish("b", false, 800, Type.MEAT),
            new Dish("beef", false, 700, Type.MEAT),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french fries", true, 530, Type.OTHER),
            new Dish("rice", true, 350, Type.OTHER),
            new Dish("season fruit", true, 120, Type.OTHER),
            new Dish("pizza", true, 550, Type.OTHER),
            new Dish("prawns", false, 300, Type.FISH),
            new Dish("salmon", false, 450, Type.FISH));
    @Test
    public void TestDish(){
        if (menu.stream().anyMatch(Dish::isVegetarian))  {
            System.out.println("1");
        }
        boolean b = menu.stream().allMatch(d->d.getCalories() < 1000);
        System.out.println(b);
        Optional<Dish> any = menu.stream().findFirst();
        System.out.println(any);


        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        Integer result1 = Stream.of(1,2,3).reduce(10, (x, y) -> x + y, (x, y) -> x * y);
        System.out.println(result1);
        List<Integer> list=Arrays.asList(1,2,3,4,5,6);
        Integer reduce = list.stream().reduce(720, (x, y) -> x/y);
        System.out.println(list.stream().reduce(10,(x,y)->x+y));
        list.stream().map(i->i).forEach(System.out::println);
        System.out.println(reduce);
    }

    @Test
    public void TestOptional(){
        Optional<Dish> op = Optional.of(new Dish("b", false, 800, Type.MEAT));
        System.out.println(op);
        Optional<Dish> op2 = Optional.of(null);
        System.out.println(op2);
    }
    @Test
    public void TestJDK9() throws InterruptedException{
        String s="124154512";
        Arrays.stream(s.chars().map(i -> (int) i-48).toArray()).forEach(System.out::println);
        IntStream intStream = s.chars().map(i -> (int) (i+1000));
        IntStream.iterate( -1 , i -> i < 100 , i -> i + 1 ).forEach(System.out::println);
        var a=1;
        System.out.println(a);
        TreeSet<String> treeSet=new TreeSet<>();
        List<String> list=List.of("1","1","1","2","3","4");
        treeSet.addAll(list);
        System.out.println(treeSet);
    }
    @Test
    public void TestJDK91() throws InterruptedException{
        List<String> list=List.of("A","A","B","C","a","b","C","6","5","6","5","2","1");
        TreeSet<String> treeSet=new TreeSet<String>(Comparator.comparing(String::toLowerCase));
        treeSet.addAll(list);
        ArrayList<String> strings = new ArrayList<>(treeSet);
        System.out.println(strings);
//        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//        long[] allThreadIds = threadMXBean.getAllThreadIds();
//        ThreadInfo[] infos = threadMXBean.getThreadInfo(allThreadIds);
//        Arrays.stream(infos).map(a->a.getThreadName()).forEach(System.out::println);
    }
    @Test
    public void TestJDK10() throws IOException {
        //定义一个字符串
        String newStr = new String("符官正");
        String s = new String(newStr.getBytes(), "utf-8");
        System.out.println(newStr);
        //输入流将字符串转换成字节,并以gbk编码格式输入
        ByteArrayInputStream bis = new ByteArrayInputStream(newStr.getBytes("gbk"));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int c = 0;
        while((c = bis.read()) != -1) {
            bos.write(c);
        }
        //bos.toString() 默认的使用的UTF-8编码
        System.out.println(bos.toString());

        //所以上面输入使用gbk那么后面输出也要使用gbk
        System.out.println(bos.toString("gbk"));

        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream("D://a.txt"), "gbk"));
        PrintWriter printWriter = new PrintWriter(new File("d://b.txt"));
        read.transferTo(printWriter);
        printWriter.flush();
        printWriter.close();
        read.close();
    }
    @Test
    public void TestJDK11() throws IOException, InterruptedException, ExecutionException {
//        HttpClient client             = HttpClient.newHttpClient();
//        HttpRequest request           = HttpRequest.newBuilder(URI.create("https://my.oschina.net/mdxlcj/blog/3010342")).build();
//        HttpResponse.BodyHandler<String> handler  = HttpResponse.BodyHandlers.ofString();
//        HttpResponse<String> response = client.send(request,handler);
//        //异步处理
//        CompletableFuture<HttpResponse<String>> response1 = client.sendAsync(request, handler);
//        HttpResponse<String> stringHttpResponse = response1.get();
//        int i = response.statusCode();
//        String body                   = stringHttpResponse.body();
//        System.out.println(i+"::"+body);

        DecimalFormat f=new DecimalFormat("#.##");
        Float f1=1.0321321f;
        String format = f.format(f1);
        System.out.println(format);
        double d=1.78787989;
        BigDecimal d1=new BigDecimal(0.1);
        BigDecimal d2=new BigDecimal(0.2);
        System.out.println(d1.add(d2));
        double v = d1.doubleValue();
        System.out.println(v);
        BigDecimal d3=new BigDecimal(String.valueOf(d));
        System.out.println(d3);

        int x = -1;
        assert x < 0;
        System.out.println(x);

        Logger logger = Logger.getGlobal();
        logger.fine("ignored.");
        logger.severe("process will be terminated...");
        logger.info("start process...");
        logger.warning("memory is running out...");

    }
    @Test
    public void TestLog4j(){
        Date date = new Date();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy:MM:dd");
        String format = simpleFormatter.format(date);
        System.out.println(format);
    }
}
