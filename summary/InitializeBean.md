initializeBean (빈이름, 빈, 빈정의)
빈 초기화

1
invokeAwareMethods (빈 이름, 빈)
알고있는 메소드들을 호출

BeanNameAware 
BeanClassLoaderAware
BeanFactoryAware

'빈' 이 세 가지 경우의 타입인지 확인하고, 
해당할 경우, BeanName, BeanClassLoader, BeanFactory 를 set 해준다.


2 (옵션: 빈 정의가 없거나, 빈 정의가 Synthetic 이 아닐때 실행)
applyBeanPostProcessorsBeforeInitialization (빈, 빈 이름)
초기화 전에 빈 후처리기를 적용

3
invokeInitMethods (빈 이름, 빈, 빈 정의)
초기화 메소들을 호출
내부적으로 InitializingBean 인터페이스의 afterPropertiesSet() 메소드 사용
BeanCreationException 예외처리

4 (옵션: 빈 정의가 없거나, 빈 정의가 Synthetic 이 아닐때 실행)
applyBeanPostProcessorsAfterInitialization (빈, 빈 이름)
초기화 후에 빈 후처리기를 적용

5
빈 반환 ~!

