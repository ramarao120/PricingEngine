# Project Name: PricingEngine
#Instalation:
1.git clone https://github.com/ramarao120/PricingEngine.git
2.import the project into eclipse or run with maven
3.install lombok plugin 

#Implementation:
1.Created moven project and added junit and lombok jars
2.Implemented PromotionEngine test classes
3.Based on test cases created service interface and implementation classes
4.implemented utility clasess to reuse the code and utilized the lombok feature to optimize promotionion feature
5.Enable the lombok plugin in eclipse

#Test Cases:
Scenario A
1 * A     50
1 * B     30
1 * C     20
======
Final Price:     100

Scenario B
5 * A     130 + 2*50
5 * B     45 + 45 + 30
1 * C     20
======

Final Price:370

Scenario C
3 * A     130
5 * B     45 + 45 + 1 * 30
1 * C     -
1 * D     30
======

Final Price:280

