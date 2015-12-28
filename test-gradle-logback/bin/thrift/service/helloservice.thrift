namespace java com.zpeng.gen.thrift.service

include "../pojo/helloworld.thrift"

service Hello{
	string helloString(1:string str)
	i32 helloInt(1:i32 para) 
	bool helloBoolean(1:bool para) 
	void helloVoid() 
	string helloNull() 
	list<string> helloList(1:list<string> helloStrList)
	helloworld.Emotion helloStruct(1:helloworld.Emotion emotion)
}