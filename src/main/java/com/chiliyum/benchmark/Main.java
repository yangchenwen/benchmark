package com.chiliyum.benchmark;

import org.hibernate.engine.jdbc.internal.FormatStyle;
import org.hibernate.engine.jdbc.internal.Formatter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author yangchenwen
 * @since 2020-08-04 09:41:21
 */
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
public class Main {

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void formatUsingEnumsFormatter() {
        formatUsingEnumsFormatter("insert into Address (city, state, zip, \"from\") values (?, ?, ?, 'insert value')");
        formatUsingEnumsFormatter("delete from Address where id = ? and version = ?");
        formatUsingEnumsFormatter("update Address set city = ?, state=?, zip=?, version = ? where id = ? and version = ?");
        formatUsingEnumsFormatter("update Address set city = ?, state=?, zip=?, version = ? where id in (select aid from Person)");
        formatUsingEnumsFormatter(
                "select p.name, a.zipCode, count(*) from Person p left outer join Employee e on e.id = p.id and p.type = 'E' and (e.effective>? or e.effective<?) join Address a on a.pid = p.id where upper(p.name) like 'G%' and p.age > 100 and (p.sex = 'M' or p.sex = 'F') and coalesce( trim(a.street), a.city, (a.zip) ) is not null order by p.name asc, a.zipCode asc"
        );
        formatUsingEnumsFormatter(
                "select ( (m.age - p.age) * 12 ), trim(upper(p.name)) from Person p, Person m where p.mother = m.id and ( p.age = (select max(p0.age) from Person p0 where (p0.mother=m.id)) and p.name like ? )"
        );
        formatUsingEnumsFormatter(
                "select * from Address a join Person p on a.pid = p.id, Person m join Address b on b.pid = m.id where p.mother = m.id and p.name like ?"
        );
        formatUsingEnumsFormatter(
                "select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        formatUsingEnumsFormatter(
                "/* Here we' go! */ select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        formatUsingEnumsFormatter(
                "(select p.pid from Address where city = 'Boston') union (select p.pid from Address where city = 'Taipei')"
        );
        formatUsingEnumsFormatter("select group0.[order] as order0 from [Group] group0 where group0.[order]=?1");
    }

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void formatUsingOriginalFormatter() {
        formatUsingOriginalFormatter("insert into Address (city, state, zip, \"from\") values (?, ?, ?, 'insert value')");
        formatUsingOriginalFormatter("delete from Address where id = ? and version = ?");
        formatUsingOriginalFormatter("update Address set city = ?, state=?, zip=?, version = ? where id = ? and version = ?");
        formatUsingOriginalFormatter("update Address set city = ?, state=?, zip=?, version = ? where id in (select aid from Person)");
        formatUsingOriginalFormatter(
                "select p.name, a.zipCode, count(*) from Person p left outer join Employee e on e.id = p.id and p.type = 'E' and (e.effective>? or e.effective<?) join Address a on a.pid = p.id where upper(p.name) like 'G%' and p.age > 100 and (p.sex = 'M' or p.sex = 'F') and coalesce( trim(a.street), a.city, (a.zip) ) is not null order by p.name asc, a.zipCode asc"
        );
        formatUsingOriginalFormatter(
                "select ( (m.age - p.age) * 12 ), trim(upper(p.name)) from Person p, Person m where p.mother = m.id and ( p.age = (select max(p0.age) from Person p0 where (p0.mother=m.id)) and p.name like ? )"
        );
        formatUsingOriginalFormatter(
                "select * from Address a join Person p on a.pid = p.id, Person m join Address b on b.pid = m.id where p.mother = m.id and p.name like ?"
        );
        formatUsingOriginalFormatter(
                "select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        formatUsingOriginalFormatter(
                "/* Here we' go! */ select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        formatUsingOriginalFormatter(
                "(select p.pid from Address where city = 'Boston') union (select p.pid from Address where city = 'Taipei')"
        );
        formatUsingOriginalFormatter("select group0.[order] as order0 from [Group] group0 where group0.[order]=?1");
    }

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void formatUsingMethodHandlesFormatter() {
        formatUsingMethodHandlesFormatter("insert into Address (city, state, zip, \"from\") values (?, ?, ?, 'insert value')");
        formatUsingMethodHandlesFormatter("delete from Address where id = ? and version = ?");
        formatUsingMethodHandlesFormatter("update Address set city = ?, state=?, zip=?, version = ? where id = ? and version = ?");
        formatUsingMethodHandlesFormatter("update Address set city = ?, state=?, zip=?, version = ? where id in (select aid from Person)");
        formatUsingMethodHandlesFormatter(
                "select p.name, a.zipCode, count(*) from Person p left outer join Employee e on e.id = p.id and p.type = 'E' and (e.effective>? or e.effective<?) join Address a on a.pid = p.id where upper(p.name) like 'G%' and p.age > 100 and (p.sex = 'M' or p.sex = 'F') and coalesce( trim(a.street), a.city, (a.zip) ) is not null order by p.name asc, a.zipCode asc"
        );
        formatUsingMethodHandlesFormatter(
                "select ( (m.age - p.age) * 12 ), trim(upper(p.name)) from Person p, Person m where p.mother = m.id and ( p.age = (select max(p0.age) from Person p0 where (p0.mother=m.id)) and p.name like ? )"
        );
        formatUsingMethodHandlesFormatter(
                "select * from Address a join Person p on a.pid = p.id, Person m join Address b on b.pid = m.id where p.mother = m.id and p.name like ?"
        );
        formatUsingMethodHandlesFormatter(
                "select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        formatUsingMethodHandlesFormatter(
                "/* Here we' go! */ select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        formatUsingMethodHandlesFormatter(
                "(select p.pid from Address where city = 'Boston') union (select p.pid from Address where city = 'Taipei')"
        );
        formatUsingMethodHandlesFormatter("select group0.[order] as order0 from [Group] group0 where group0.[order]=?1");
    }

    private void formatUsingEnumsFormatter(String query) {
        Formatter formatter = FormatStyle.BASIC_ENUMS.getFormatter();
        for (int i = 0; i < 10000; i++) {
            formatter.format(query);
        }
    }

    private void formatUsingOriginalFormatter(String query) {
        Formatter formatter = FormatStyle.BASIC_ORIGIN.getFormatter();
        for (int i = 0; i < 10000; i++) {
            formatter.format(query);
        }
    }

    private void formatUsingMethodHandlesFormatter(String query) {
        Formatter formatter = FormatStyle.BASIC_METHOD_HANDLES.getFormatter();
        for (int i = 0; i < 10000; i++) {
            formatter.format(query);
        }
    }

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(Main.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
