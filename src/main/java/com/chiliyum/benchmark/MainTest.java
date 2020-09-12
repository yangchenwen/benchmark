package com.chiliyum.benchmark;

import org.hibernate.engine.jdbc.internal.FormatStyle;
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
public class MainTest {

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void formatOnceUsingEnumsFormatter() {
        formatOnceUsingEnumsFormatter("insert into Address (city, state, zip, \"from\") values (?, ?, ?, 'insert value')");
        formatOnceUsingEnumsFormatter("delete from Address where id = ? and version = ?");
        formatOnceUsingEnumsFormatter("update Address set city = ?, state=?, zip=?, version = ? where id = ? and version = ?");
        formatOnceUsingEnumsFormatter("update Address set city = ?, state=?, zip=?, version = ? where id in (select aid from Person)");
        formatOnceUsingEnumsFormatter(
                "select p.name, a.zipCode, count(*) from Person p left outer join Employee e on e.id = p.id and p.type = 'E' and (e.effective>? or e.effective<?) join Address a on a.pid = p.id where upper(p.name) like 'G%' and p.age > 100 and (p.sex = 'M' or p.sex = 'F') and coalesce( trim(a.street), a.city, (a.zip) ) is not null order by p.name asc, a.zipCode asc"
        );
        formatOnceUsingEnumsFormatter(
                "select ( (m.age - p.age) * 12 ), trim(upper(p.name)) from Person p, Person m where p.mother = m.id and ( p.age = (select max(p0.age) from Person p0 where (p0.mother=m.id)) and p.name like ? )"
        );
        formatOnceUsingEnumsFormatter(
                "select * from Address a join Person p on a.pid = p.id, Person m join Address b on b.pid = m.id where p.mother = m.id and p.name like ?"
        );
        formatOnceUsingEnumsFormatter(
                "select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        formatOnceUsingEnumsFormatter(
                "/* Here we' go! */ select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        formatOnceUsingEnumsFormatter(
                "(select p.pid from Address where city = 'Boston') union (select p.pid from Address where city = 'Taipei')"
        );
        formatOnceUsingEnumsFormatter("select group0.[order] as order0 from [Group] group0 where group0.[order]=?1");
    }

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void formatOnceUsingOriginalFormatter() {
        formatOnceUsingOriginalFormatter("insert into Address (city, state, zip, \"from\") values (?, ?, ?, 'insert value')");
        formatOnceUsingOriginalFormatter("delete from Address where id = ? and version = ?");
        formatOnceUsingOriginalFormatter("update Address set city = ?, state=?, zip=?, version = ? where id = ? and version = ?");
        formatOnceUsingOriginalFormatter("update Address set city = ?, state=?, zip=?, version = ? where id in (select aid from Person)");
        formatOnceUsingOriginalFormatter(
                "select p.name, a.zipCode, count(*) from Person p left outer join Employee e on e.id = p.id and p.type = 'E' and (e.effective>? or e.effective<?) join Address a on a.pid = p.id where upper(p.name) like 'G%' and p.age > 100 and (p.sex = 'M' or p.sex = 'F') and coalesce( trim(a.street), a.city, (a.zip) ) is not null order by p.name asc, a.zipCode asc"
        );
        formatOnceUsingOriginalFormatter(
                "select ( (m.age - p.age) * 12 ), trim(upper(p.name)) from Person p, Person m where p.mother = m.id and ( p.age = (select max(p0.age) from Person p0 where (p0.mother=m.id)) and p.name like ? )"
        );
        formatOnceUsingOriginalFormatter(
                "select * from Address a join Person p on a.pid = p.id, Person m join Address b on b.pid = m.id where p.mother = m.id and p.name like ?"
        );
        formatOnceUsingOriginalFormatter(
                "select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        formatOnceUsingOriginalFormatter(
                "/* Here we' go! */ select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        formatOnceUsingOriginalFormatter(
                "(select p.pid from Address where city = 'Boston') union (select p.pid from Address where city = 'Taipei')"
        );
        formatOnceUsingOriginalFormatter("select group0.[order] as order0 from [Group] group0 where group0.[order]=?1");
    }

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void formatOnceUsingMethodHandlesFormatter() {
        formatOnceUsingMethodHandlesFormatter("insert into Address (city, state, zip, \"from\") values (?, ?, ?, 'insert value')");
        formatOnceUsingMethodHandlesFormatter("delete from Address where id = ? and version = ?");
        formatOnceUsingMethodHandlesFormatter("update Address set city = ?, state=?, zip=?, version = ? where id = ? and version = ?");
        formatOnceUsingMethodHandlesFormatter("update Address set city = ?, state=?, zip=?, version = ? where id in (select aid from Person)");
        formatOnceUsingMethodHandlesFormatter(
                "select p.name, a.zipCode, count(*) from Person p left outer join Employee e on e.id = p.id and p.type = 'E' and (e.effective>? or e.effective<?) join Address a on a.pid = p.id where upper(p.name) like 'G%' and p.age > 100 and (p.sex = 'M' or p.sex = 'F') and coalesce( trim(a.street), a.city, (a.zip) ) is not null order by p.name asc, a.zipCode asc"
        );
        formatOnceUsingMethodHandlesFormatter(
                "select ( (m.age - p.age) * 12 ), trim(upper(p.name)) from Person p, Person m where p.mother = m.id and ( p.age = (select max(p0.age) from Person p0 where (p0.mother=m.id)) and p.name like ? )"
        );
        formatOnceUsingMethodHandlesFormatter(
                "select * from Address a join Person p on a.pid = p.id, Person m join Address b on b.pid = m.id where p.mother = m.id and p.name like ?"
        );
        formatOnceUsingMethodHandlesFormatter(
                "select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        formatOnceUsingMethodHandlesFormatter(
                "/* Here we' go! */ select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        formatOnceUsingMethodHandlesFormatter(
                "(select p.pid from Address where city = 'Boston') union (select p.pid from Address where city = 'Taipei')"
        );
        formatOnceUsingMethodHandlesFormatter("select group0.[order] as order0 from [Group] group0 where group0.[order]=?1");
    }

    private void formatOnceUsingEnumsFormatter(String query) {
        FormatStyle.BASIC_ENUMS.getFormatter().format(query);
    }

    private void formatOnceUsingOriginalFormatter(String query) {
        FormatStyle.BASIC_ORIGIN.getFormatter().format(query);
    }

    private void formatOnceUsingMethodHandlesFormatter(String query) {
        FormatStyle.BASIC_METHOD_HANDLES.getFormatter().format(query);
    }

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(MainTest.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
