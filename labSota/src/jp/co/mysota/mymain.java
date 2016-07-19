//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.sotatalk.SpeechRecog.*;
import	java.awt.Color;
import	jp.vstone.camera.*;
import	java.io.*;
import	java.time.*;

public class mymain
{

	public jp.co.mysota.face faceRegistration;
	public CRobotPose pose;
	public String speechRecogResult;
	public jp.co.mysota.face face;
	public String date_string;
	public String readText;
	public RecogResult recogresult;
	public LocalDateTime localDateTime;
	public String time_string;
	public void getName()																								//@<BlockInfo>jp.vstone.block.func,32,416,528,416,False,2,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		speechRecogResult = GlobalVariable.recog.getNamewithAbort((int)60000 , (int)3);									//@<BlockInfo>jp.vstone.block.talk.getname,96,368,464,368,False,1,音声認識を行い、名前を取得する。取得結果はメンバー変数のspeechRecogResultに格納される。@</BlockInfo>

		if(speechRecogResult != null)
		{
																														//@<OutputChild>
																														//@</OutputChild>

		}else
		{
																														//@<OutputChild>
																														//@</OutputChild>

		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void clearData()																								//@<BlockInfo>jp.vstone.block.func,32,240,320,240,False,5,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(true);																//@<BlockInfo>jp.vstone.block.facedetect.detect,112,240,240,240,False,4,顔検出@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceDetect();
		{
			GlobalVariable.detectCount=0;

																														//@<OutputChild>
			{																											//@<BlockInfo>jp.vstone.block.facedetect.user.clear,176,240,176,240,False,3,登録した顔のクリア(全消去)@</BlockInfo>
				for(int i=0;i<20;i++)
				{
					if(GlobalVariable.robocam.isAliveFaceDetectTask()) { GlobalVariable.robocam.clearUser(); break; }
					CRobotUtil.wait(100);
					if(i==10-1) CRobotUtil.Err("FaceUser", "顔検出が実行されていません。このブロックを使う際は、顔検出、顔追従ブロックに囲われた箇所で使用してください。");
				}
			}																											//@<EndOfBlock/>
																														//@</OutputChild>

		}
		GlobalVariable.robocam.StopFaceDetect();

																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	/*
	clearData();																										//@<BlockInfo>jp.vstone.block.callfunc.base,640,32,640,32,False,6,@</BlockInfo>	@<EndOfBlock/>

	*/

	//@<Separate/>
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,32,672,32,False,16,@</BlockInfo>
	{
																														//@<OutputChild>
		faceRegistration=new jp.co.mysota.face();																		//@<BlockInfo>jp.vstone.block.variable,96,32,96,32,False,15,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*CRobotPose pose*/;																							//@<BlockInfo>jp.vstone.block.variable,160,32,160,32,False,14,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String speechRecogResult*/;																					//@<BlockInfo>jp.vstone.block.variable,224,32,224,32,False,13,break@</BlockInfo>
																														//@<EndOfBlock/>
		face=new jp.co.mysota.face();																					//@<BlockInfo>jp.vstone.block.variable,288,32,288,32,False,12,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String date_string*/;																							//@<BlockInfo>jp.vstone.block.variable,352,32,352,32,False,11,break@</BlockInfo>
																														//@<EndOfBlock/>
		readText="";																									//@<BlockInfo>jp.vstone.block.variable,416,32,416,32,False,10,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*RecogResult recogresult*/;																					//@<BlockInfo>jp.vstone.block.variable,480,32,480,32,False,9,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*LocalDateTime localDateTime*/;																				//@<BlockInfo>jp.vstone.block.variable,544,32,544,32,False,8,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String time_string*/;																							//@<BlockInfo>jp.vstone.block.variable,608,32,608,32,False,7,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	/*
	recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);												//@<BlockInfo>jp.vstone.block.talk.speechrecog.regex2,928,480,992,480,False,17,音声認識を行い、結果を条件に正規表現文字列で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
	speechRecogResult = recogresult.CheckBest(new String[]{
	 ".*こんにちは.*" ,  "" , 
	},true);
	if(speechRecogResult == null) speechRecogResult = "";

	if(speechRecogResult.contains((String)".*こんにちは.*"))
	{
		speechRecogResult = recogresult.getBasicResult();
		if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
																														//@</OutputChild>

	}
	else
	{
		speechRecogResult = recogresult.getBasicResult();
		if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
																														//@</OutputChild>

	}
																														//@<EndOfBlock/>

	*/

	//@<Separate/>
	/*
	try{																												//@<BlockInfo>jp.vstone.block.text.read,480,256,480,256,False,20,リソースに登録したテキストファイルを読み込んで、変数String readTextに代入します@</BlockInfo>
		File file = new File("resource/体温.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

		readText="";
		String read;
		while((read = br.readLine()) != null){
			readText += read;
		}

		br.close();
	}catch(FileNotFoundException e){
		System.out.println(e);
	}catch(IOException e){
		System.out.println(e);
	}
																														//@<EndOfBlock/>
	try{																												//@<BlockInfo>jp.vstone.block.freeproc,544,256,544,256,False,19,@</BlockInfo>
		File file = new File("resource/体温.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

		bw.write(date_string + time_string);
		bw.newLine();
		bw.write("まきのくん　38℃");
		bw.newLine();
		System.out.println("OK");
		bw.write("たかしくん　36℃");
		bw.newLine();
		System.out.println("OK");

		bw.close();
		}catch(FileNotFoundException e){
		System.out.println(e);
		}catch(IOException e){
		System.out.println(e);
		}
																														//@<EndOfBlock/>
	{																													//@<BlockInfo>jp.vstone.block.talk.tts,608,256,608,256,False,18,動作を伴わず音声合成のみ行います。@</BlockInfo>
		String file = TextToSpeechSota.getTTSFile((String)readText,(int)11,(int)13,(int)11);
		if(file!=null) CPlayWave.PlayWave(file,true);
	}
																														//@<EndOfBlock/>

	*/

	//@<Separate/>
	public void method()																								//@<BlockInfo>jp.vstone.block.func,816,336,1056,336,False,21,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void main()																									//@<BlockInfo>jp.vstone.block.func,32,144,576,144,False,28,コメント@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.motion.ServoOn();																				//@<BlockInfo>jp.vstone.block.motoron,96,144,96,144,False,27,ON@</BlockInfo>	@<EndOfBlock/>
		time_string = CRobotUtil.getTimeString();																		//@<BlockInfo>jp.vstone.block.time.gettime,176,144,176,144,False,26,ロボット内のカレンダーより現在時刻を文字列で取得し、変数String time_stringに代入。@</BlockInfo>
																														//@<EndOfBlock/>
		date_string = CRobotUtil.getDateString();																		//@<BlockInfo>jp.vstone.block.time.getdate,240,144,240,144,False,25,ロボット内のカレンダーより現在年月日を文字列で取得し、変数String date_stringに代入。@</BlockInfo>
																														//@<EndOfBlock/>
		CPlayWave.PlayWave("resource/OPEN.wav",false);																	//@<BlockInfo>jp.vstone.block.sound2,320,144,320,144,False,24,コメント@</BlockInfo>	@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,384,144,384,144,False,23,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{7,-1222,-33,1191,90,-22,-60,-13}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,0,80,80,0,80,80}
						);
		GlobalVariable.motion.play(pose,200);
		CRobotUtil.wait(200);																							//@<EndOfBlock/>
		faceRegistration.faceRegistration();																			//@<BlockInfo>jp.vstone.block.callfunc.base,448,144,448,144,False,30,@</BlockInfo>	@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,512,144,512,144,False,22,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,0,80,80,0,80,80}
						);
		GlobalVariable.motion.play(pose,200);
		CRobotUtil.wait(200);																							//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	/*
	face.callName();																									//@<BlockInfo>jp.vstone.block.callfunc.base,720,144,720,144,False,29,@</BlockInfo>	@<EndOfBlock/>

	*/

}
