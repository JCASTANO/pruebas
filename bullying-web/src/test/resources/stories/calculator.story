Narrative:
Small example on how to add two numbers

Scenario:  Zero input
Given a calculator
When <number1> + <number2>
Then result should be <result>

Examples:
|number1|number2|result|
|0|0|0|
|1|0|1|
|0|1|1|
|-1|0|-1|

Scenario:  Negative inputs
Given a calculator
When <number1> + <number2>
Then result should be <result>

Examples:
|number1|number2|result|
|-1|0|-1|
|-1|-1|-2|
|-1|4|3|

Scenario:  Positive inputs
Given a calculator
When <number1> + <number2>
Then result should be <result>

Examples:
|number1|number2|result|
|1|1|2|
|1|3|4|
|10|40|50|