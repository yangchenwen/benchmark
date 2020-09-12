# BENCHMARK RESULT

#### JMH version: 1.19
#### VM version: JDK 1.8.0_232, VM 25.232-b09

---
>14 different SQLs, each SQL formatted for 10,000 times.

#### RESULT 1:
Run complete. Total time: 00:01:17

| Benchmark | Mode | Cnt | Score | Error | Units |
| :-------- | :--- | :---| :---- | :-----| ----: |
| Main.formatUsingEnumsFormatter         | thrpt   | 5 | 1.639 ± 0.062 | | ops/s|
| Main.formatUsingMethodHandlesFormatter | thrpt   | 5 | 1.725 ± 0.210 | | ops/s|
| Main.formatUsingOriginalFormatter      | thrpt   | 5 | 1.713 ± 0.081 | | ops/s|
| Main.formatUsingEnumsFormatter          | avgt   | 5 | 0.602 ± 0.017 | |  s/op|
| Main.formatUsingMethodHandlesFormatter  | avgt   | 5 | 0.588 ± 0.018 | |  s/op|
| Main.formatUsingOriginalFormatter       | avgt   | 5 | 0.581 ± 0.017 | |  s/op|

---
#### RESULT 2:
Run complete. Total time: 00:01:18

|Benchmark  |  Mode | Cnt | Score |  Error | Units|
| :-------- | :--- | :---| :---- | :-----| ----: |
|Main.formatUsingEnumsFormatter         | thrpt  |  5 | 1.665 ± 0.108 | |  ops/s |
|Main.formatUsingMethodHandlesFormatter | thrpt  |  5 | 1.703 ± 0.113 | |  ops/s |
|Main.formatUsingOriginalFormatter      | thrpt  |  5 | 1.695 ± 0.080 | |  ops/s |
|Main.formatUsingEnumsFormatter          | avgt  |  5 | 0.609 ± 0.030 | |   s/op |
|Main.formatUsingMethodHandlesFormatter  | avgt  |  5 | 0.591 ± 0.014 | |   s/op |
|Main.formatUsingOriginalFormatter       | avgt  |  5 | 0.598 ± 0.004 | |   s/op |

---
#### RESULT 3:
Run complete. Total time: 00:01:18

|Benchmark |  Mode  |Cnt | Score |  Error | Units|
| :-------- | :--- | :---| :---- | :-----| ----: |          
Main.formatUsingEnumsFormatter         | thrpt   | 5 | 1.688 ± 0.085 | |  ops/s |
Main.formatUsingMethodHandlesFormatter | thrpt   | 5 | 1.695 ± 0.060 | |  ops/s |
Main.formatUsingOriginalFormatter      | thrpt   | 5 | 1.698 ± 0.192 | |  ops/s |
Main.formatUsingEnumsFormatter          | avgt   | 5 | 0.607 ± 0.030  | |  s/op |
Main.formatUsingMethodHandlesFormatter  | avgt   | 5 | 0.601 ± 0.037  | |  s/op |
Main.formatUsingOriginalFormatter       | avgt   | 5 | 0.575 ± 0.038  | |  s/op |

---
---

>14 different SQLs, each SQL formatted for 1 time.

#### RESULT 4:


 Run complete. Total time: 00:01:06

|Benchmark  |  Mode | Cnt |  Score  |  Error | Units|
| :-------- | :---  | :---| :----   | :----- | ----: |
|MainTest.formatOnceUsingEnumsFormatter         | thrpt   | 5 |   0.016 ± 0.001 | |  ops/us|
|MainTest.formatOnceUsingMethodHandlesFormatter | thrpt   | 5 |   0.016 ± 0.001 | |  ops/us|
|MainTest.formatOnceUsingOriginalFormatter      | thrpt   | 5 |   0.016 ± 0.001 | |  ops/us|
|MainTest.formatOnceUsingEnumsFormatter          | avgt   | 5 |  63.756 ± 2.288  | |  us/op|
|MainTest.formatOnceUsingMethodHandlesFormatter  | avgt   | 5 |  60.989 ± 3.042  | |  us/op|
|MainTest.formatOnceUsingOriginalFormatter       | avgt   | 5 |  63.442 ± 2.691  | |  us/op|

#### RESULT 5:

 Run complete. Total time: 00:01:06

|Benchmark  |  Mode | Cnt |  Score  |  Error | Units|
| :-------- | :---  | :---| :----   | :----- | ----: |
|MainTest.formatOnceUsingEnumsFormatter          |thrpt    |5|   0.015 ± 0.001 | | ops/us|
|MainTest.formatOnceUsingMethodHandlesFormatter  |thrpt    |5|   0.016 ± 0.001 | | ops/us|
|MainTest.formatOnceUsingOriginalFormatter       |thrpt    |5|   0.016 ± 0.001 | | ops/us|
|MainTest.formatOnceUsingEnumsFormatter           |avgt    |5|  63.965 ± 2.592  | | us/op|
|MainTest.formatOnceUsingMethodHandlesFormatter   |avgt    |5|  62.690 ± 2.864  | | us/op|
|MainTest.formatOnceUsingOriginalFormatter        |avgt    |5|  63.321 ± 2.055  | | us/op|


#### RESULT 6:

 Run complete. Total time: 00:01:06

|Benchmark  |  Mode | Cnt |  Score  |  Error | Units|
| :-------- | :---  | :---| :----   | :----- | ----: |
|MainTest.formatOnceUsingEnumsFormatter          |thrpt    |5|   0.016 ± 0.001 | | ops/us|
|MainTest.formatOnceUsingMethodHandlesFormatter  |thrpt    |5|   0.016 ± 0.001 | | ops/us|
|MainTest.formatOnceUsingOriginalFormatter       |thrpt    |5|   0.016 ± 0.001 | | ops/us|
|MainTest.formatOnceUsingEnumsFormatter           |avgt    |5|  61.507 ± 2.139  | | us/op|
|MainTest.formatOnceUsingMethodHandlesFormatter   |avgt    |5|  62.925 ± 2.297  | | us/op|
|MainTest.formatOnceUsingOriginalFormatter        |avgt    |5|  63.715 ± 2.818  | | us/op|