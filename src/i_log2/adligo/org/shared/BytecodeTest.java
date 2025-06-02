package i_log2.adligo.org.shared;

import org.adligo.i_log2.shared.DefaultLogFactory;
import org.adligo.i_log2.shared.I_Log;
/**
 * This code was kept as simple as possible to create readable bytecode to prove that the "hello world" and "good bye world" strings
 * are not created when the I_Log is set to a higher level than Debug.  As you can see from the following bytecode
 * the lambdas for the Supplier<String>'s are compiled into private static methods which Load Constant (the <a href='https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.ldc'>'ldc'</a> opcode in the bytecode),
 * and then return the string (the <a href='https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.areturn'>'areturn'</a> opcode in the bytecode).
 * Although this creates a lot more bytecode, it uses less memory since the strings are not created unless needed.
 * 
 * The compiled bytecode follows;
 * 
 * <code><pre>
// Compiled from BytecodeTest.java (version 24 : 68.0, super bit)
1  public class i_log2.adligo.org.shared.BytecodeTest extends org.adligo.i_log2.shared.DefaultLogFactory {
  
2    // Method descriptor #6 ()V
3    // Stack: 1, Locals: 1
4    public BytecodeTest();
5      0  aload_0 [this]
6      1  invokespecial org.adligo.i_log2.shared.DefaultLogFactory() [8]
7      4  return
8        Line numbers:
9          [pc: 0, line: 85]
10       Local variable table:
11         [pc: 0, pc: 5] local: this index: 0 type: i_log2.adligo.org.shared.BytecodeTest
12  
13   // Method descriptor #15 ([Ljava/lang/String;)V
14   // Stack: 2, Locals: 2
15   public static void main(java.lang.String[] args);
16      0  getstatic i_log2.adligo.org.shared.BytecodeTest.THIS : org.adligo.i_log2.shared.DefaultLogFactory [16]
17      3  ldc <String "foo"> [20]
18      5  invokevirtual org.adligo.i_log2.shared.DefaultLogFactory.getOrCreateLog(java.lang.String) : org.adligo.i_log2.shared.DefaultLog [22]
19      8  astore_1 [log]
20      9  aload_1 [log]
21     10  invokedynamic 0 get() : java.util.function.Supplier [26]
22     15  invokeinterface org.adligo.i_log2.shared.I_Log.ifDebug(java.util.function.Supplier) : void [30] [nargs: 2]
23     20  aload_1 [log]
24     21  invokedynamic 1 get() : java.util.function.Supplier [36]
25     26  invokeinterface org.adligo.i_log2.shared.I_Log.ifDebug(java.util.function.Supplier) : void [30] [nargs: 2]
26     31  return
27       Line numbers:
28         [pc: 0, line: 88]
29         [pc: 9, line: 89]
30         [pc: 20, line: 90]
31         [pc: 31, line: 91]
32       Local variable table:
33         [pc: 0, pc: 32] local: args index: 0 type: java.lang.String[]
34         [pc: 9, pc: 32] local: log index: 1 type: org.adligo.i_log2.shared.I_Log
35  
36   // Method descriptor #42 ()Ljava/lang/Object;
37   // Stack: 1, Locals: 0
38   private static synthetic java.lang.Object lambda$0();
39     0  ldc <String "hello world"> [43]
40     2  areturn
41       Line numbers:
42         [pc: 0, line: 89]
43  
44   // Method descriptor #42 ()Ljava/lang/Object;
45   // Stack: 1, Locals: 0
46   private static synthetic java.lang.Object lambda$1();
47     0  ldc <String "good bye world"> [46]
48     2  areturn
49       Line numbers:
50         [pc: 0, line: 90]
51 
52   Inner classes:
53     [inner class info: #69 java/lang/invoke/MethodHandles$Lookup, outer class info: #71 java/lang/invoke/MethodHandles
54      inner name: #73 Lookup, accessflags: 25 public static final]
55 Bootstrap methods:
56   0 : # 57 invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
57     Method arguments:
58         #58 ()Ljava/lang/Object;
59         #61 invokestatic i_log2/adligo/org/shared/BytecodeTest.lambda$0:()Ljava/lang/Object;
60         #62 ()Ljava/lang/Object;,
61   1 : # 57 invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
62     Method arguments:
63         #63 ()Ljava/lang/Object;
64         #66 invokestatic i_log2/adligo/org/shared/BytecodeTest.lambda$1:()Ljava/lang/Object;
65         #67 ()Ljava/lang/Object;
66 }
</pre></code>
 * 
 * @author scott 
 * 
 *         <pre>
 * <code>
 *         ---------------- Apache ICENSE-2.0 --------------------------
 *
 *         Copyright 2025 Adligo Inc
 * 
 *         Licensed under the Apache License, Version 2.0 (the "License"); you
 *         may not use this file except in compliance with the License. You may
 *         obtain a copy of the License at
 * 
 *         http://www.apache.org/licenses/LICENSE-2.0
 * 
 *         Unless required by applicable law or agreed to in writing, software
 *         distributed under the License is distributed on an "AS IS" BASIS,
 *         WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *         implied. See the License for the specific language governing
 *         permissions and limitations under the License.
 *         </code>
 *         </pre>
 */
public class BytecodeTest extends DefaultLogFactory {

  public static void main(String [] args) {
    I_Log log =  THIS.getOrCreateLog("foo");
    log.ifDebug(() -> "hello world");
    log.ifDebug(() -> "good bye world");
  }
}
