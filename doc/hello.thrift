#定义一个单一服务HelloWorldService, 多服务的支持从0.9.1开始
#包含一个接口sayHello

service  HelloWorldService {
  string sayHello(1:string username)
}

service TopicService{
  string echo(1:string displayWords)
}