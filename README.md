# BENCHMARK RESULT

#### JMH version: 1.19
#### VM version: JDK 1.8.0_232, VM 25.232-b09

---
>`testFormat_new` uses the formatter with enums chain  
>`testFormat_old` uses the original formatter


#### RESULT 1:
Run complete. Total time: 00:01:00

| Benchmark | Mode | Cnt | Score | Error | Units |
| :-------- | :--- | :---| :---- | :-----| ----: |
| Main.testFormat_new |  thrpt  |  5 | 1.654 ± 0.024 | |ops/s | 
| Main.testFormat_old |  thrpt  |  5 | 1.691 ± 0.050 | |ops/s | 
| Main.testFormat_new |   avgt  |  5 | 0.597 ± 0.024 | | s/op | 
| Main.testFormat_old |   avgt  |  5 | 0.580 ± 0.004 | | s/op |

---
#### RESULT 2:
Run complete. Total time: 00:00:59

|Benchmark  |  Mode | Cnt | Score |  Error | Units|
| :-------- | :--- | :---| :---- | :-----| ----: |
|Main.testFormat_new | thrpt | 5 | 1.686 ± 0.025 | |ops/s|
|Main.testFormat_old | thrpt | 5 | 1.737 ± 0.016 | |ops/s|
|Main.testFormat_new |  avgt | 5 | 0.601 ± 0.044 | | s/op|
|Main.testFormat_old |  avgt | 5 | 0.579 ± 0.027 | | s/op|

---
#### RESULT 3:
Run complete. Total time: 00:01:00

|Benchmark |  Mode  |Cnt | Score |  Error | Units|
| :-------- | :--- | :---| :---- | :-----| ----: |          
|Main.testFormat_new | thrpt  | 5 | 1.627 ± 0.022 | |ops/s|
|Main.testFormat_old | thrpt  | 5 | 1.715 ± 0.057 | |ops/s|
|Main.testFormat_new |  avgt  | 5 | 0.588 ± 0.022 | | s/op|
|Main.testFormat_old |  avgt  | 5 | 0.582 ± 0.019 | | s/op|

---
---

>`testFormat_new_once` uses the formatter with enums chain(call once)  
>`testFormat_old_once` uses the original formatter(call once) 
#### RESULT 4:


 Run complete. Total time: 00:00:44

|Benchmark  |  Mode | Cnt |  Score  |  Error | Units|
| :-------- | :---  | :---| :----   | :----- | ----: |
|Main.testFormat_new_once | thrpt |   5 |  0.015 ±  0.001 |  |ops/us|
|Main.testFormat_old_once | thrpt |   5 |  0.016 ±  0.001 |  |ops/us|
|Main.testFormat_new_once |  avgt |   5 | 65.084 ±  2.507 |  | us/op|
|Main.testFormat_old_once |  avgt |   5 | 64.723 ±  1.394 |  | us/op|

#### RESULT 5:

 Run complete. Total time: 00:00:44

|Benchmark  |  Mode | Cnt |  Score  |  Error | Units|
| :-------- | :---  | :---| :----   | :----- | ----: |
|Main.testFormat_new_once | thrpt |   5 |  0.016 ±  0.001 |  |ops/us|
|Main.testFormat_old_once | thrpt |   5 |  0.016 ±  0.001 |  |ops/us|
|Main.testFormat_new_once |  avgt |   5 | 65.066 ±  1.715 |  | us/op|
|Main.testFormat_old_once |  avgt |   5 | 64.789 ±  2.192 |  | us/op|


#### RESULT 6:

 Run complete. Total time: 00:00:44

|Benchmark  |  Mode | Cnt |  Score  |  Error | Units|
| :-------- | :---  | :---| :----   | :----- | ----: |
|Main.testFormat_new_once | thrpt |   5 |  0.015 ± 0.001 |  |ops/us|
|Main.testFormat_old_once | thrpt |   5 |  0.015 ± 0.001 |  |ops/us|
|Main.testFormat_new_once |  avgt |   5 | 63.081 ± 2.136 |  | us/op|
|Main.testFormat_old_once |  avgt |   5 | 65.709 ± 0.564 |  | us/op|