# What is AOP (Aspect Oriented Programming)

- Programming paradigm that helps with separation of cross-cutting concerns
    - Complements OOP
- Adds additional behavior (Advice) without modifying existing code (too much)
    - Can specify which code is modified by specifying "Pointcut" - example: log all methods with prefix `set`

# AOP in Micronaut

- How it's implemented depends on the language/framework
- Micronaut implements AOP using java annotations processing
    - Compile time 
    - Reflection free

## Three Types of Advices

1. Around Advice
1. Introduction Advice
1. Method Adapter Advice
