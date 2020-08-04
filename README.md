# BENCHMARK RESULT

#### JMH version: 1.19
#### VM version: JDK 1.8.0_232, VM 25.232-b09

---
>`testFormat_new` use the formatter with enums loop  
>`testFormat_old` use the original formatter


#### RESULT 1:
Run complete. Total time: 00:01:00

| Benchmark | Mode | Cnt | Score | Error | Units |
| :-------- | :--- | :---| :---- | :-----| ----: |
| Main.testFormat_new |  thrpt  |  5 | 1.261 ± 0.010 | |ops/s | 
| Main.testFormat_old |  thrpt  |  5 | 1.715 ± 0.014 | |ops/s | 
| Main.testFormat_new |   avgt  |  5 | 0.805 ± 0.015 | | s/op | 
| Main.testFormat_old |   avgt  |  5 | 0.588 ± 0.002 | | s/op |

---
#### RESULT 2:
Run complete. Total time: 00:00:59

|Benchmark  |  Mode | Cnt | Score |  Error | Units|
| :-------- | :--- | :---| :---- | :-----| ----: |
|Main.testFormat_new | thrpt | 5 | 1.268 ± 0.025 | |ops/s|
|Main.testFormat_old | thrpt | 5 | 1.752 ± 0.014 | |ops/s|
|Main.testFormat_new |  avgt | 5 | 0.797 ± 0.004 | | s/op|
|Main.testFormat_old |  avgt | 5 | 0.586 ± 0.008 | | s/op|

---
#### RESULT 3:
Run complete. Total time: 00:01:00

|Benchmark |  Mode  |Cnt | Score |  Error | Units|
| :-------- | :--- | :---| :---- | :-----| ----: |          
|Main.testFormat_new | thrpt  | 5 | 1.267 ± 0.005 | |ops/s|
|Main.testFormat_old | thrpt  | 5 | 1.713 ± 0.014 | |ops/s|
|Main.testFormat_new |  avgt  | 5 | 0.796 ± 0.015 | | s/op|
|Main.testFormat_old |  avgt  | 5 | 0.593 ± 0.005 | | s/op|

---
#### RESULT 4:
>`testFormat_new_once` use the formatter with enums loop(call once)  
>`testFormat_old_once` use the original formatter(call once) 

 Run complete. Total time: 00:00:44

|Benchmark  |  Mode | Cnt |  Score  |  Error | Units|
| :-------- | :---  | :---| :----   | :----- | ----: |
|Main.testFormat_new_once | thrpt |   5 |  0.012 ±  0.001 |  |ops/us|
|Main.testFormat_old_once | thrpt |   5 |  0.016 ±  0.001 |  |ops/us|
|Main.testFormat_new_once |  avgt |   5 | 85.092 ±  0.849 |  | us/op|
|Main.testFormat_old_once |  avgt |   5 | 65.453 ±  1.538 |  | us/op|