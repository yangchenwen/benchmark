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
public class Main {

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void testFormat_new() {
        format_new("insert into Address (city, state, zip, \"from\") values (?, ?, ?, 'insert value')");
        format_new("delete from Address where id = ? and version = ?");
        format_new("update Address set city = ?, state=?, zip=?, version = ? where id = ? and version = ?");
        format_new("update Address set city = ?, state=?, zip=?, version = ? where id in (select aid from Person)");
        format_new(
                "select p.name, a.zipCode, count(*) from Person p left outer join Employee e on e.id = p.id and p.type = 'E' and (e.effective>? or e.effective<?) join Address a on a.pid = p.id where upper(p.name) like 'G%' and p.age > 100 and (p.sex = 'M' or p.sex = 'F') and coalesce( trim(a.street), a.city, (a.zip) ) is not null order by p.name asc, a.zipCode asc"
        );
        format_new(
                "select ( (m.age - p.age) * 12 ), trim(upper(p.name)) from Person p, Person m where p.mother = m.id and ( p.age = (select max(p0.age) from Person p0 where (p0.mother=m.id)) and p.name like ? )"
        );
        format_new(
                "select * from Address a join Person p on a.pid = p.id, Person m join Address b on b.pid = m.id where p.mother = m.id and p.name like ?"
        );
        format_new(
                "select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        format_new(
                "/* Here we' go! */ select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        format_new(
                "(select p.pid from Address where city = 'Boston') union (select p.pid from Address where city = 'Taipei')"
        );
        format_new("select group0.[order] as order0 from [Group] group0 where group0.[order]=?1");
    }

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void testFormat_old() {
        format_old("insert into Address (city, state, zip, \"from\") values (?, ?, ?, 'insert value')");
        format_old("delete from Address where id = ? and version = ?");
        format_old("update Address set city = ?, state=?, zip=?, version = ? where id = ? and version = ?");
        format_old("update Address set city = ?, state=?, zip=?, version = ? where id in (select aid from Person)");
        format_old(
                "select p.name, a.zipCode, count(*) from Person p left outer join Employee e on e.id = p.id and p.type = 'E' and (e.effective>? or e.effective<?) join Address a on a.pid = p.id where upper(p.name) like 'G%' and p.age > 100 and (p.sex = 'M' or p.sex = 'F') and coalesce( trim(a.street), a.city, (a.zip) ) is not null order by p.name asc, a.zipCode asc"
        );
        format_old(
                "select ( (m.age - p.age) * 12 ), trim(upper(p.name)) from Person p, Person m where p.mother = m.id and ( p.age = (select max(p0.age) from Person p0 where (p0.mother=m.id)) and p.name like ? )"
        );
        format_old(
                "select * from Address a join Person p on a.pid = p.id, Person m join Address b on b.pid = m.id where p.mother = m.id and p.name like ?"
        );
        format_old(
                "select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        format_old(
                "/* Here we' go! */ select case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end from Person p where ( case when p.age > 50 then 'old' when p.age > 18 then 'adult' else 'child' end ) like ?"
        );
        format_old(
                "(select p.pid from Address where city = 'Boston') union (select p.pid from Address where city = 'Taipei')"
        );
        format_old("select group0.[order] as order0 from [Group] group0 where group0.[order]=?1");
    }

    private void format_new(String query) {
        for (int i = 0; i < 10000; i++) {
            FormatStyle.BASIC.getFormatter().format(query);
        }
    }

    private void format_old(String query) {
        for (int i = 0; i < 10000; i++) {
            FormatStyle.BASIC_OLD.getFormatter().format(query);
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
