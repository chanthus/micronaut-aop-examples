# What is AOP (Aspect Oriented Programming)

- Programming paradigm that helps with separation of cross-cutting concerns
    - Complements OOP
- Adds additional behavior (Advice) to without modifying existing code (too much)
    - Can specify which code is modified by specifying "Pointcut" 

# AOP in Micronaut

- How it's implemented depends on the language/framework
- Micronaut implements AOP using java annotations processing
    - Compile time 
    - Reflection free

## Three Types

1. Around Advice
1. Introduction Advice
1. Method Adapter Advice
