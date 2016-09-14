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
import	jp.vstone.camera.FaceDetectLib.*;
import	java.util.Random;
import	twitter4j.Status;
import	twitter4j.Twitter;
import	twitter4j.TwitterException;
import	twitter4j.TwitterFactory;
import	twitter4j.User;
import	twitter4j.conf.*;

public class mymain
{

	public CRobotPose pose;
	public String speechRecogResult;
	public String ocName;
	public String date_string;
	public String readText;
	public RecogResult recogresult;
	public LocalDateTime localDateTime;
	public String time_string;
	public int addFaceuserErrSayInterval;
	public String faceName;
	public String callName;
	public int faceDetectResultSmile;
	public int faceDetectResultAge;
	public int gender;
	public long noDetectDuration;
	public long detectDuration;
	public boolean exist;
	/*
	try{																												//@<BlockInfo>jp.vstone.block.text.read,896,240,896,240,False,3,リソースに登録したテキストファイルを読み込んで、変数String readTextに代入します@</BlockInfo>
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
	try{																												//@<BlockInfo>jp.vstone.block.freeproc,960,240,960,240,False,2,@</BlockInfo>
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
	{																													//@<BlockInfo>jp.vstone.block.talk.tts,1024,240,1024,240,False,1,動作を伴わず音声合成のみ行います。@</BlockInfo>
		String file = TextToSpeechSota.getTTSFile((String)readText,(int)11,(int)13,(int)11);
		if(file!=null) CPlayWave.PlayWave(file,true);
	}
																														//@<EndOfBlock/>

	*/

	//@<Separate/>
	public void callName()																								//@<BlockInfo>jp.vstone.block.func,64,1344,1440,1344,False,18,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,336,1344,1376,1344,False,17,tracking@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,400,1344,1312,1344,False,16,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,464,1296,1248,1296,False,15,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)2)
				{
																														//@<OutputChild>
					GlobalVariable.faceuser = GlobalVariable.robocam.getUser(GlobalVariable.faceresult);				//@<BlockInfo>jp.vstone.block.facedetect.user.get2,528,1248,1184,1248,False,13,認識した顔の特徴を取得して、グローバル変数FaceUser faceuserに代入します。また、登録済みのユーザの場合、名前をグローバル変数String facenameに代入します。@</BlockInfo>

					if(GlobalVariable.faceuser != null)
					{
						if(GlobalVariable.faceuser.getName() != null) GlobalVariable.facename = GlobalVariable.faceuser.getName();
						else GlobalVariable.facename="";
						
																														//@<OutputChild>
							if(!GlobalVariable.faceuser.isNewUser())														//@<BlockInfo>jp.vstone.block.facedetect.user.isknow,592,1200,1120,1200,False,11,グローバル変数FaceUser faceuserに記録された顔が登録された顔であるか@</BlockInfo>
							{
																															//@<OutputChild>
								callName=(String)GlobalVariable.facename;													//@<BlockInfo>jp.vstone.block.calculater,656,1200,656,1200,False,9,@</BlockInfo>
																															//@<EndOfBlock/>
								System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");											//@<BlockInfo>jp.vstone.block.freeproc,720,1200,720,1200,False,8,@</BlockInfo>
								System.out.println(callName + "を認識しました。");
								System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");
																															//@<EndOfBlock/>
								GlobalVariable.sotawish.Say((String)callName + "こんにちは。",MotionAsSotaWish.MOTION_TYPE_HELLO,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,784,1200,784,1200,False,7,@</BlockInfo>
																															//@<EndOfBlock/>
								GlobalVariable.sotawish.Say((String)"写真撮りまーす！",MotionAsSotaWish.MOTION_TYPE_CALL,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,848,1200,848,1200,False,6,@</BlockInfo>
																															//@<EndOfBlock/>
								takePhoto();																				//@<BlockInfo>jp.vstone.block.callfunc.base,992,1200,992,1200,False,5,@</BlockInfo>	@<EndOfBlock/>
								break;																						//@<BlockInfo>jp.vstone.block.break,1056,1200,1056,1200,False,4,break@</BlockInfo>	@<EndOfBlock/>
																															//@</OutputChild>
							
							}else
							{
																															//@<OutputChild>
								CPlayWave.PlayWave("resource/NG.wav",false);												//@<BlockInfo>jp.vstone.block.sound2,720,1296,720,1296,False,10,コメント@</BlockInfo>	@<EndOfBlock/>
																															//@</OutputChild>
							
							}
																															//@<EndOfBlock/>
																																//@</OutputChild>

					}
					else
					{
						
																														//@<OutputChild>
							CPlayWave.PlayWave("resource/NG.wav",false);													//@<BlockInfo>jp.vstone.block.sound2,656,1344,656,1344,False,12,コメント@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

					}
																														//@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
					CPlayWave.PlayWave("resource/NG.wav",false);														//@<BlockInfo>jp.vstone.block.sound2,592,1392,592,1392,False,14,コメント@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>


		}finally{
			GlobalVariable.robocam.StopFaceTraking();
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void faceRegistration()																						//@<BlockInfo>jp.vstone.block.func,32,640,1440,592,False,40,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,96,640,1376,592,False,39,tracking@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,160,640,1312,592,False,38,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,224,592,1248,544,False,37,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)2)
				{
																														//@<OutputChild>
					GlobalVariable.faceuser = GlobalVariable.robocam.getUser(GlobalVariable.faceresult);				//@<BlockInfo>jp.vstone.block.facedetect.user.get2,304,432,1184,496,False,32,認識した顔の特徴を取得して、グローバル変数FaceUser faceuserに代入します。また、登録済みのユーザの場合、名前をグローバル変数String facenameに代入します。@</BlockInfo>

					if(GlobalVariable.faceuser != null)
					{
						if(GlobalVariable.faceuser.getName() != null) GlobalVariable.facename = GlobalVariable.faceuser.getName();
						else GlobalVariable.facename="";
						
																														//@<OutputChild>
							if(!GlobalVariable.faceuser.isNewUser())														//@<BlockInfo>jp.vstone.block.facedetect.user.isknow,368,384,1088,384,False,30,グローバル変数FaceUser faceuserに記録された顔が登録された顔であるか@</BlockInfo>
							{
																															//@<OutputChild>
								callName=(String)GlobalVariable.facename;													//@<BlockInfo>jp.vstone.block.calculater,448,336,448,336,False,22,@</BlockInfo>
																															//@<EndOfBlock/>
								GlobalVariable.sotawish.Say((String)"君は" + callName + "だよね？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,512,336,512,336,False,21,@</BlockInfo>
																															//@<EndOfBlock/>
															System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");											//@<BlockInfo>jp.vstone.block.freeproc,576,336,576,336,False,20,@</BlockInfo>
															System.out.println(callName + "は登録済みです。");
															System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");
							
															try{
																File file = new File("resource/動作ログ.txt");
																BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
							
																bw.write("[" + time_string + "]" + "既に登録されている" + " " + callName + " " + "を認識しました。");
																bw.newLine();
							
																bw.close();
																}catch(FileNotFoundException e){
																System.out.println(e);
																}catch(IOException e){
																System.out.println(e);
																}
																															//@<EndOfBlock/>
								break;																						//@<BlockInfo>jp.vstone.block.break,672,336,672,336,False,19,break@</BlockInfo>	@<EndOfBlock/>
																															//@</OutputChild>
							
							}else
							{
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"はじめまして！、名前を教えてくれない？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,432,480,432,480,False,29,@</BlockInfo>
																															//@<EndOfBlock/>
								speechRecogResult = GlobalVariable.recog.getNamewithAbort((int)60000 , (int)3);				//@<BlockInfo>jp.vstone.block.talk.getname,496,432,1024,432,False,28,音声認識を行い、名前を取得する。取得結果はメンバー変数のspeechRecogResultに格納される。@</BlockInfo>
							
								if(speechRecogResult != null)
								{
																															//@<OutputChild>
									if(GlobalVariable.faceuser!=null)														//@<BlockInfo>jp.vstone.block.facedetect.user.add,576,400,832,400,False,27,@</BlockInfo>
									{
										GlobalVariable.faceuser.setName((String)speechRecogResult);
										int faceuserAddReturnCode = GlobalVariable.robocam.addUserwithErrorCode(GlobalVariable.faceuser);
										boolean isfaceuseradd = (faceuserAddReturnCode==1);
							
										String errMessageVoice=null;
										switch(faceuserAddReturnCode)
										{
											case -100: errMessageVoice="ユーザ情報がありません。";
											break;
											case -201: errMessageVoice="顔が上や下を向いているみたい。まっすぐ前を向いてください";
											break;
											case -202: errMessageVoice="首が傾いているみたい。まっすぐにしてください";
											break;
											case -203: errMessageVoice="顔が横を向いているみたい。まっすぐ前を見てください";
											break;
											case -300: errMessageVoice="もっと近くで顔を見せてください。";
											break;
											case -400: errMessageVoice="顔が良く見えませんでした。しっかり顔を見せてください。";
											break;
											case -500: errMessageVoice="顔が見つかりませんでした。";
											break;
										}
										if(errMessageVoice!=null && ++addFaceuserErrSayInterval == 3)
										{
											addFaceuserErrSayInterval=0;
											String file = TextToSpeechSota.getTTSFile(errMessageVoice);
											if(file!=null) CPlayWave.PlayWave(file,true);
										}
									 
										if(isfaceuseradd==true)
										{
																															//@<OutputChild>
										GlobalVariable.sotawish.Say((String)"君のことは覚えたよ！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,400,640,400,False,25,@</BlockInfo>
																															//@<EndOfBlock/>
																															System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");									//@<BlockInfo>jp.vstone.block.freeproc,704,400,704,400,False,24,@</BlockInfo>
																															System.out.println("新しい人物を登録しました。");
																															System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");
							
																															try{
																																File file = new File("resource/動作ログ.txt");
																																BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
							
																																bw.write("[" + time_string + "]" + "新しい人物を登録しました。");
																																bw.newLine();
							
																																bw.close();
																																}catch(FileNotFoundException e){
																																System.out.println(e);
																																}catch(IOException e){
																																System.out.println(e);
																																}
																															//@<EndOfBlock/>
										break;																				//@<BlockInfo>jp.vstone.block.break,768,400,768,400,False,23,break@</BlockInfo>	@<EndOfBlock/>
																															//@</OutputChild>
							
										}else
										{
																															//@<OutputChild>
										GlobalVariable.sotawish.Say((String)"ごめん～！登録できなかったよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,496,640,496,False,26,@</BlockInfo>
																															//@<EndOfBlock/>
																															//@</OutputChild>
							
										}
							
									}
																															//@<EndOfBlock/>
																															//@</OutputChild>
							
								}else
								{
																															//@<OutputChild>
																															//@</OutputChild>
							
								}
																															//@<EndOfBlock/>
																															//@</OutputChild>
							
							}
																															//@<EndOfBlock/>
																																//@</OutputChild>

					}
					else
					{
						
																														//@<OutputChild>
							GlobalVariable.sotawish.Say((String)"おぼえられない～！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,384,608,384,608,False,31,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>

					}
																														//@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
					switch(GlobalVariable.random.nextInt((int)3))														//@<BlockInfo>jp.vstone.block.random,320,688,480,688,False,36,@</BlockInfo>
					{
						case (int)0:
						{
																														//@<OutputChild>
							{																								//@<BlockInfo>jp.vstone.block.talk.tts,400,688,400,688,False,33,動作を伴わず音声合成のみ行います。@</BlockInfo>
								String file = TextToSpeechSota.getTTSFile((String)"もっとよく顔をみせて～！",(int)11,(int)13,(int)11);
								if(file!=null) CPlayWave.PlayWave(file,true);
							}
																															//@<EndOfBlock/>
																																//@</OutputChild>
							break;
						}
						case (int)1:
						{
																														//@<OutputChild>
							{																								//@<BlockInfo>jp.vstone.block.talk.tts,400,784,400,784,False,34,動作を伴わず音声合成のみ行います。@</BlockInfo>
								String file = TextToSpeechSota.getTTSFile((String)"あと少しで覚えられそうだ！",(int)11,(int)13,(int)11);
								if(file!=null) CPlayWave.PlayWave(file,true);
							}
																															//@<EndOfBlock/>
																																//@</OutputChild>
							break;
						}
						default:
						{
																														//@<OutputChild>
							{																								//@<BlockInfo>jp.vstone.block.talk.tts,400,880,400,880,False,35,動作を伴わず音声合成のみ行います。@</BlockInfo>
								String file = TextToSpeechSota.getTTSFile((String)"ふむふむふむ",(int)11,(int)13,(int)11);
								if(file!=null) CPlayWave.PlayWave(file,true);
							}
																															//@<EndOfBlock/>
																																//@</OutputChild>
							break;
						}

					}																									//@<EndOfBlock/>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>


		}finally{
			GlobalVariable.robocam.StopFaceTraking();
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	/*
	faceRegistration();																									//@<BlockInfo>jp.vstone.block.callfunc.base,704,224,704,224,False,41,@</BlockInfo>	@<EndOfBlock/>

	*/

	//@<Separate/>
	/*
	callName();																											//@<BlockInfo>jp.vstone.block.callfunc.base,592,224,592,224,False,42,@</BlockInfo>	@<EndOfBlock/>

	*/

	//@<Separate/>
	public void likeVideo()																								//@<BlockInfo>jp.vstone.block.func,0,2192,624,2192,False,44,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.initStill(new CameraCapture(CameraCapture.CAP_IMAGE_SIZE_QVGA, CameraCapture.CAP_FORMAT_MJPG));	//@<BlockInfo>jp.vstone.block.freeproc,272,2192,272,2192,False,43,@</BlockInfo>
				while(true){
							{
								String filepath = "/var/sota/photo/";
								filepath += (String)"abc";
								boolean isTrakcing=GlobalVariable.robocam.isAliveFaceDetectTask();
								if(isTrakcing) GlobalVariable.robocam.StopFaceTraking();
								GlobalVariable.robocam.StillPicture(filepath);
								CRobotUtil.Log("stillpicture","save picthre file to \"" + filepath +"\"");
								if(isTrakcing) GlobalVariable.robocam.StartFaceTraking();
							}
						}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void openCampus()																							//@<BlockInfo>jp.vstone.block.func,0,1824,1200,2032,False,81,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.Say((String)"こんにちは～！",MotionAsSotaWish.MOTION_TYPE_HELLO,(int)11,(int)13,(int)11);		//@<BlockInfo>jp.vstone.block.talk.say,64,1824,64,1824,False,80,@</BlockInfo>
																														//@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)"あなたの名前を教えてほしいな！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,128,1824,128,1824,False,79,@</BlockInfo>
																														//@<EndOfBlock/>
		while(GlobalVariable.TRUE)																						//@<BlockInfo>jp.vstone.block.while.endless,192,1824,800,1744,False,78,Endless@</BlockInfo>
		{

																														//@<OutputChild>
			speechRecogResult = GlobalVariable.recog.getNamewithAbort((int)60000 , (int)3);								//@<BlockInfo>jp.vstone.block.talk.getname,256,1776,736,1696,False,51,音声認識を行い、名前を取得する。取得結果はメンバー変数のspeechRecogResultに格納される。@</BlockInfo>

			if(speechRecogResult != null)
			{
																														//@<OutputChild>
				GlobalVariable.sotawish.Say((String)speechRecogResult + "さん、で合ってる？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,320,1776,320,1776,False,50,@</BlockInfo>
																														//@<EndOfBlock/>
				ocName=(String)speechRecogResult;																		//@<BlockInfo>jp.vstone.block.calculater,384,1776,384,1776,False,49,@</BlockInfo>
																														//@<EndOfBlock/>
				speechRecogResult = GlobalVariable.recog.getYesorNowithAbort((int)60000 , (int)3);						//@<BlockInfo>jp.vstone.block.talk.getyesno,464,1600,656,1600,False,48,音声認識を行い、肯定/否定を取得する。取得結果はメンバー変数のspeechRecogResultに格納され、肯定なら「YES」、否定なら「NO」、聞き取り失敗なら長さ0の文字列が代入される。@</BlockInfo>
				if(speechRecogResult==null) speechRecogResult="";

				if(speechRecogResult.equals("YES"))
				{
																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)ocName + "さん、よろしくね！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,528,1600,528,1600,False,46,@</BlockInfo>
																														//@<EndOfBlock/>
					break;																								//@<BlockInfo>jp.vstone.block.break,592,1600,592,1600,False,45,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

				}else if(speechRecogResult.equals("NO"))
				{
																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"もう一度教えてください！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,528,1696,528,1696,False,47,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>

			}else
			{
																														//@<OutputChild>
																														//@</OutputChild>

			}
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
																														//@<EndOfBlock/>
		GlobalVariable.robocam.setEnableFaceSearch(true);																//@<BlockInfo>jp.vstone.block.facedetect.traking,864,1744,880,2032,False,77,顔追従@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,928,1744,1472,1760,False,72,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,992,1696,1408,1712,False,60,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)5)
				{
																														//@<OutputChild>
					{																									//@<BlockInfo>jp.vstone.block.facedetect.gender2,1072,1520,1264,1520,False,59,@</BlockInfo>
						boolean isMale=false,isFemale=false;
						GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();
						if(GlobalVariable.faceresult.isMale()!=null) isMale = GlobalVariable.faceresult.isMale();
						if(GlobalVariable.faceresult.isFemale()!=null) isFemale = GlobalVariable.faceresult.isFemale();

						if( isMale )
						{
																														//@<OutputChild>
						GlobalVariable.sotawish.Say((String)ocName + "さんは、おとこのこだね！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1136,1520,1136,1520,False,53,@</BlockInfo>
																														//@<EndOfBlock/>
						gender=(int)0;																					//@<BlockInfo>jp.vstone.block.calculater,1200,1520,1200,1520,False,52,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

						}else if( isFemale )
						{
																														//@<OutputChild>
						GlobalVariable.sotawish.Say((String)ocName + "さんは、おんなのこだね！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1136,1616,1136,1616,False,55,@</BlockInfo>
																														//@<EndOfBlock/>
						gender=(int)1;																					//@<BlockInfo>jp.vstone.block.calculater,1200,1616,1200,1616,False,54,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

						}else
						{
																														//@<OutputChild>
						GlobalVariable.sotawish.Say((String)ocName + "さんは、男の子？女の子？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1136,1712,1136,1712,False,57,@</BlockInfo>
																														//@<EndOfBlock/>
						gender=(int)2;																					//@<BlockInfo>jp.vstone.block.calculater,1200,1712,1200,1712,False,56,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

						}
					}
																														//@<EndOfBlock/>
					break;																								//@<BlockInfo>jp.vstone.block.break,1328,1616,1328,1616,False,58,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
			GlobalVariable.sotawish.Say((String)"笑って笑って～！こっち見て～！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,16,2032,16,2032,False,71,@</BlockInfo>
																														//@<EndOfBlock/>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,80,2032,336,2032,False,70,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,144,1984,272,1984,False,62,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)2)
				{
																														//@<OutputChild>
					break;																								//@<BlockInfo>jp.vstone.block.break,208,1984,208,1984,False,61,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
			GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();										//@<BlockInfo>jp.vstone.block.facedetect.smile.get2,416,2032,416,2032,False,69,最後に認識された顔の年齢がfaceDetectResultSmileに格納される。@</BlockInfo>
			faceDetectResultSmile = GlobalVariable.faceresult.getSmile();												//@<EndOfBlock/>
			GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();										//@<BlockInfo>jp.vstone.block.facedetect.age.get2,480,2032,480,2032,False,68,現在認識している顔の年齢がfaceDetectResultAgeに格納される。顔が認識されない場合、faceDetectResultAgeに-1が代入される。@</BlockInfo>
			faceDetectResultAge = GlobalVariable.faceresult.getAge();													//@<EndOfBlock/>
			{																											//@<BlockInfo>jp.vstone.block.talk.tts,560,2032,560,2032,False,67,動作を伴わず音声合成のみ行います。@</BlockInfo>
				String file = TextToSpeechSota.getTTSFile((String)"あなたの笑顔の点数は～",(int)11,(int)13,(int)11);
				if(file!=null) CPlayWave.PlayWave(file,true);
			}
																														//@<EndOfBlock/>
			GlobalVariable.sotawish.Say((String)String.valueOf(faceDetectResultSmile) + "点でした～！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,624,2032,624,2032,False,66,@</BlockInfo>
																														//@<EndOfBlock/>
			if(faceDetectResultSmile>70)																				//@<BlockInfo>jp.vstone.block.if,688,1984,816,1984,False,65,コメント@</BlockInfo>
			{
																														//@<OutputChild>
				GlobalVariable.sotawish.Say((String)"素敵な笑顔～！ありがとう～！",MotionAsSotaWish.MOTION_TYPE_CALL,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,752,1984,752,1984,False,63,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
			else
			{
																														//@<OutputChild>
				GlobalVariable.sotawish.Say((String)"いい笑顔だね！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,752,2080,752,2080,False,64,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>


		}finally{
			GlobalVariable.robocam.StopFaceTraking();
		}
																														//@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)"最後に写真撮りまーす！こっちをみて～！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,944,2032,944,2032,False,76,@</BlockInfo>
																														//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.facedetect.stillpicture,1008,2032,1008,2032,False,75,still@</BlockInfo>
			String filepath = "/var/sota/photo/";
			filepath += (String)"picture";
			boolean isTrakcing=GlobalVariable.robocam.isAliveFaceDetectTask();
			if(isTrakcing) GlobalVariable.robocam.StopFaceTraking();
			GlobalVariable.robocam.initStill(new CameraCapture(CameraCapture.CAP_IMAGE_SIZE_5Mpixel, CameraCapture.CAP_FORMAT_MJPG));
			GlobalVariable.robocam.StillPicture(filepath);

			CRobotUtil.Log("stillpicture","save picthre file to \"" + filepath +"\"");
			if(isTrakcing) GlobalVariable.robocam.StartFaceTraking();
		}																												//@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)"写真撮れました！ありがとう～！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1072,2032,1072,2032,False,74,@</BlockInfo>
																														//@<EndOfBlock/>
		try{																											//@<BlockInfo>jp.vstone.block.freeproc,1136,2032,1136,2032,False,73,@</BlockInfo>
			File file = new File("resource/OCtest.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

			bw.write("なまえ:" + ocName);
			bw.newLine();
			if(gender == 0){
			bw.write("せいべつ:男");
			}else if(gender == 1){
			bw.write("せいべつ:女");
			}else{
			bw.write("せいべつ:わかりませんでした");
			}
			bw.newLine();
			bw.write("ねんれい:" + String.valueOf(faceDetectResultAge));
			bw.newLine();
			bw.write("えがお:" + String.valueOf(faceDetectResultSmile));
			bw.newLine();

			bw.close();
			}catch(FileNotFoundException e){
			System.out.println(e);
			}catch(IOException e){
			System.out.println(e);
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void main()																									//@<BlockInfo>jp.vstone.block.func,32,144,1200,144,False,92,コメント@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.motion.ServoOn();																				//@<BlockInfo>jp.vstone.block.motoron,96,144,96,144,False,91,ON@</BlockInfo>	@<EndOfBlock/>
		time_string = CRobotUtil.getTimeString();																		//@<BlockInfo>jp.vstone.block.time.gettime,160,144,160,144,False,90,ロボット内のカレンダーより現在時刻を文字列で取得し、変数String time_stringに代入。@</BlockInfo>
																														//@<EndOfBlock/>
		date_string = CRobotUtil.getDateString();																		//@<BlockInfo>jp.vstone.block.time.getdate,224,144,224,144,False,89,ロボット内のカレンダーより現在年月日を文字列で取得し、変数String date_stringに代入。@</BlockInfo>
																														//@<EndOfBlock/>
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");																//@<BlockInfo>jp.vstone.block.freeproc,368,144,368,144,False,88,@</BlockInfo>
		System.out.println("日時と時刻を取得しました。");
		System.out.println("Sotaを起動します。");
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");

		try{
			File file = new File("resource/動作ログ.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

			bw.write("[" + date_string + " " + time_string + "]" + "プログラムを実行しました。");
			bw.newLine();

			bw.close();
			}catch(FileNotFoundException e){
			System.out.println(e);
			}catch(IOException e){
			System.out.println(e);
			}
																														//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.talk.tts,432,144,432,144,False,87,動作を伴わず音声合成のみ行います。@</BlockInfo>
			String file = TextToSpeechSota.getTTSFile((String)"テストはじめます。",(int)11,(int)13,(int)11);
			if(file!=null) CPlayWave.PlayWave(file,true);
		}
																														//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,512,144,512,144,False,86,コメント@</BlockInfo>
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
		openCampus();																									//@<BlockInfo>jp.vstone.block.callfunc.base,576,144,576,144,False,85,@</BlockInfo>	@<EndOfBlock/>
		time_string = CRobotUtil.getTimeString();																		//@<BlockInfo>jp.vstone.block.time.gettime,640,144,640,144,False,84,ロボット内のカレンダーより現在時刻を文字列で取得し、変数String time_stringに代入。@</BlockInfo>
																														//@<EndOfBlock/>
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");																//@<BlockInfo>jp.vstone.block.freeproc,704,144,704,144,False,83,@</BlockInfo>
		System.out.println("プログラムを終了します。");
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");

		try{
			File file = new File("resource/動作ログ.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

			bw.write("[" + date_string + " " + time_string + "]" + "プログラムを終了しました。");
			bw.newLine();
			bw.newLine();

			bw.close();
			}catch(FileNotFoundException e){
			System.out.println(e);
			}catch(IOException e){
			System.out.println(e);
			}
																														//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,768,144,768,144,False,82,コメント@</BlockInfo>
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
	public void clearData()																								//@<BlockInfo>jp.vstone.block.func,32,240,320,240,False,95,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(true);																//@<BlockInfo>jp.vstone.block.facedetect.detect,112,240,240,240,False,94,顔検出@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceDetect();
		try{
			GlobalVariable.detectCount=0;

																														//@<OutputChild>
			{																											//@<BlockInfo>jp.vstone.block.facedetect.user.clear,176,240,176,240,False,93,登録した顔のクリア(全消去)@</BlockInfo>
				for(int i=0;i<20;i++)
				{
					if(GlobalVariable.robocam.isAliveFaceDetectTask()) { GlobalVariable.robocam.clearUser(); break; }
					CRobotUtil.wait(100);
					if(i==10-1) CRobotUtil.Err("FaceUser", "顔検出が実行されていません。このブロックを使う際は、顔検出、顔追従ブロックに囲われた箇所で使用してください。");
				}
			}																											//@<EndOfBlock/>
																														//@</OutputChild>

		}finally{
			GlobalVariable.robocam.StopFaceDetect();
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void welcomeTweets()																							//@<BlockInfo>jp.vstone.block.func,0,2400,768,2400,False,105,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,64,2400,704,2400,False,104,顔追従@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,128,2400,640,2400,False,103,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,192,2352,576,2352,False,102,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)2)
				{
																														//@<OutputChild>
					GlobalVariable.faceuser = GlobalVariable.robocam.getUser(GlobalVariable.faceresult);				//@<BlockInfo>jp.vstone.block.facedetect.user.get2,256,2304,512,2304,False,101,認識した顔の特徴を取得して、グローバル変数FaceUser faceuserに代入します。また、登録済みのユーザの場合、名前をグローバル変数String facenameに代入します。@</BlockInfo>

					if(GlobalVariable.faceuser != null)
					{
						if(GlobalVariable.faceuser.getName() != null) GlobalVariable.facename = GlobalVariable.faceuser.getName();
						else GlobalVariable.facename="";
						
																														//@<OutputChild>
							callName=(String)GlobalVariable.facename;														//@<BlockInfo>jp.vstone.block.calculater,320,2304,320,2304,False,98,@</BlockInfo>
																															//@<EndOfBlock/>
							try{																							//@<BlockInfo>jp.vstone.block.freeproc,384,2304,384,2304,False,97,@</BlockInfo>
							ConfigurationBuilder cb = new ConfigurationBuilder();
							cb.setDebugEnabled(true)
							  .setOAuthConsumerKey("amssqZdWo4YasEHpYacSnvLBL")
							  .setOAuthConsumerSecret("p1RjOH9z75rVXBDlPD4pfX2KV11S7glrZycxDptRgO5thDINkb")
							  .setOAuthAccessToken("4882733018-6r7fqkuAiWOtXGorBCX0eXbt3Kn6QezyW54H00d")
							  .setOAuthAccessTokenSecret("oTPnpb2asAsos7N4OWGZUeURrlPXBmn2TLcG3hk0o68Dg");
							
							TwitterFactory tf = new TwitterFactory(cb.build());
							
							Twitter tw = tf.getInstance();
							User user = tw.verifyCredentials();
							
							tw.updateStatus(callName + "が研究室に来ました。");
							}catch(TwitterException te){
							System.out.println(te);
							}
							System.out.println("Post Succeeded.");
																															//@<EndOfBlock/>
							break;																							//@<BlockInfo>jp.vstone.block.break,448,2304,448,2304,False,96,break@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

					}
					else
					{
						
																														//@<OutputChild>
							try{																							//@<BlockInfo>jp.vstone.block.freeproc,352,2400,352,2400,False,100,@</BlockInfo>
							ConfigurationBuilder cb = new ConfigurationBuilder();
							cb.setDebugEnabled(true)
							  .setOAuthConsumerKey("amssqZdWo4YasEHpYacSnvLBL")
							  .setOAuthConsumerSecret("p1RjOH9z75rVXBDlPD4pfX2KV11S7glrZycxDptRgO5thDINkb")
							  .setOAuthAccessToken("4882733018-6r7fqkuAiWOtXGorBCX0eXbt3Kn6QezyW54H00d")
							  .setOAuthAccessTokenSecret("oTPnpb2asAsos7N4OWGZUeURrlPXBmn2TLcG3hk0o68Dg");
							
							TwitterFactory tf = new TwitterFactory(cb.build());
							
							Twitter twitter = tf.getInstance();
							User user = twitter.verifyCredentials();
							
							//System.out.println("名前　　　　：" + user.getName());
							//System.out.println("表示名　　　：" + user.getScreenName());
							//System.err.println("フォロー数　：" + user.getFriendsCount());
							//System.out.println("フォロワー数：" + user.getFollowersCount());
							
							Status status = twitter.updateStatus( "知らない人が研究室に来ました。");
							}catch(TwitterException te){
							System.out.println(te);
							}
							System.out.println("ポスト成功しました。");
																															//@<EndOfBlock/>
							break;																							//@<BlockInfo>jp.vstone.block.break,416,2400,416,2400,False,99,break@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

					}
																														//@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>


		}finally{
			GlobalVariable.robocam.StopFaceTraking();
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void takePhoto()																								//@<BlockInfo>jp.vstone.block.func,48,1024,480,1024,False,111,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		date_string = CRobotUtil.getDateString();																		//@<BlockInfo>jp.vstone.block.time.getdate,112,1024,112,1024,False,110,ロボット内のカレンダーより現在年月日を文字列で取得し、変数String date_stringに代入。@</BlockInfo>
																														//@<EndOfBlock/>
		time_string = CRobotUtil.getTimeString();																		//@<BlockInfo>jp.vstone.block.time.gettime,176,1024,176,1024,False,109,ロボット内のカレンダーより現在時刻を文字列で取得し、変数String time_stringに代入。@</BlockInfo>
																														//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.facedetect.stillpicture,240,1024,240,1024,False,108,still@</BlockInfo>
			String filepath = "/var/sota/photo/";
			filepath += (String)callName+" "+date_string+" "+time_string;
			boolean isTrakcing=GlobalVariable.robocam.isAliveFaceDetectTask();
			if(isTrakcing) GlobalVariable.robocam.StopFaceTraking();
			GlobalVariable.robocam.initStill(new CameraCapture(CameraCapture.CAP_IMAGE_SIZE_5Mpixel, CameraCapture.CAP_FORMAT_MJPG));
			GlobalVariable.robocam.StillPicture(filepath);

			CRobotUtil.Log("stillpicture","save picthre file to \"" + filepath +"\"");
			if(isTrakcing) GlobalVariable.robocam.StartFaceTraking();
		}																												//@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)"いい写真が撮れました！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1024,304,1024,False,107,@</BlockInfo>
																														//@<EndOfBlock/>
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");																//@<BlockInfo>jp.vstone.block.freeproc,416,1024,416,1024,False,106,@</BlockInfo>
		System.out.println(callName + "を撮影しました。");
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");

		try{
			File file = new File("resource/動作ログ.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

			bw.write("[" + time_string + "]" + callName + " " + "の撮影を完了しました。");
			bw.newLine();
			bw.close();
			}catch(FileNotFoundException e){
			System.out.println(e);
			}catch(IOException e){
			System.out.println(e);
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void tempRegistration()																						//@<BlockInfo>jp.vstone.block.func,0,3104,1056,3104,False,118,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,64,3104,992,3104,False,117,顔追従@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,128,3104,928,3104,False,116,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,192,3056,864,3056,False,115,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)2)
				{
																														//@<OutputChild>
					GlobalVariable.faceuser = GlobalVariable.robocam.getUser(GlobalVariable.faceresult);				//@<BlockInfo>jp.vstone.block.facedetect.user.get2,256,3008,800,3008,False,114,認識した顔の特徴を取得して、グローバル変数FaceUser faceuserに代入します。また、登録済みのユーザの場合、名前をグローバル変数String facenameに代入します。@</BlockInfo>

					if(GlobalVariable.faceuser != null)
					{
						if(GlobalVariable.faceuser.getName() != null) GlobalVariable.facename = GlobalVariable.faceuser.getName();
						else GlobalVariable.facename="";
						
																														//@<OutputChild>
							if(GlobalVariable.faceuser!=null)																//@<BlockInfo>jp.vstone.block.facedetect.user.add,320,2960,736,2960,False,113,@</BlockInfo>
							{
								GlobalVariable.faceuser.setName((String)"Aさん");
								int faceuserAddReturnCode = GlobalVariable.robocam.addUserwithErrorCode(GlobalVariable.faceuser);
								boolean isfaceuseradd = (faceuserAddReturnCode==1);
							
								String errMessageVoice=null;
								switch(faceuserAddReturnCode)
								{
									case -100: errMessageVoice="ユーザ情報がありません。";
									break;
									case -201: errMessageVoice="顔が上や下を向いているみたい。まっすぐ前を向いてください";
									break;
									case -202: errMessageVoice="首が傾いているみたい。まっすぐにしてください";
									break;
									case -203: errMessageVoice="顔が横を向いているみたい。まっすぐ前を見てください";
									break;
									case -300: errMessageVoice="もっと近くで顔を見せてください。";
									break;
									case -400: errMessageVoice="顔が良く見えませんでした。しっかり顔を見せてください。";
									break;
									case -500: errMessageVoice="顔が見つかりませんでした。";
									break;
								}
								if(errMessageVoice!=null && ++addFaceuserErrSayInterval == 3)
								{
									addFaceuserErrSayInterval=0;
									String file = TextToSpeechSota.getTTSFile(errMessageVoice);
									if(file!=null) CPlayWave.PlayWave(file,true);
								}
							 
								if(isfaceuseradd==true)
								{
																															//@<OutputChild>
								{																							//@<BlockInfo>jp.vstone.block.talk.tts,384,2960,384,2960,False,112,動作を伴わず音声合成のみ行います。@</BlockInfo>
									String file = TextToSpeechSota.getTTSFile((String)"OK",(int)11,(int)13,(int)11);
									if(file!=null) CPlayWave.PlayWave(file,true);
								}
																															//@<EndOfBlock/>
																															//@</OutputChild>
							
								}else
								{
																															//@<OutputChild>
																															//@</OutputChild>
							
								}
							
							}
																															//@<EndOfBlock/>
																																//@</OutputChild>

					}
					else
					{
						
																														//@<OutputChild>
																														//@</OutputChild>

					}
																														//@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>


		}finally{
			GlobalVariable.robocam.StopFaceTraking();
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,32,1312,32,False,136,@</BlockInfo>
	{
																														//@<OutputChild>
		/*CRobotPose pose*/;																							//@<BlockInfo>jp.vstone.block.variable,160,32,160,32,False,135,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String speechRecogResult*/;																					//@<BlockInfo>jp.vstone.block.variable,224,32,224,32,False,134,break@</BlockInfo>
																														//@<EndOfBlock/>
		ocName=null;																									//@<BlockInfo>jp.vstone.block.variable,288,32,288,32,False,133,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String date_string*/;																							//@<BlockInfo>jp.vstone.block.variable,352,32,352,32,False,132,break@</BlockInfo>
																														//@<EndOfBlock/>
		readText="";																									//@<BlockInfo>jp.vstone.block.variable,416,32,416,32,False,131,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*RecogResult recogresult*/;																					//@<BlockInfo>jp.vstone.block.variable,480,32,480,32,False,130,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*LocalDateTime localDateTime*/;																				//@<BlockInfo>jp.vstone.block.variable,544,32,544,32,False,129,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String time_string*/;																							//@<BlockInfo>jp.vstone.block.variable,608,32,608,32,False,128,break@</BlockInfo>
																														//@<EndOfBlock/>
		addFaceuserErrSayInterval=0;																					//@<BlockInfo>jp.vstone.block.variable,672,32,672,32,False,127,break@</BlockInfo>
																														//@<EndOfBlock/>
		faceName=null;																									//@<BlockInfo>jp.vstone.block.variable,736,32,736,32,False,126,break@</BlockInfo>
																														//@<EndOfBlock/>
		callName=null;																									//@<BlockInfo>jp.vstone.block.variable,800,32,800,32,False,125,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*int faceDetectResultSmile*/;																					//@<BlockInfo>jp.vstone.block.variable,864,32,864,32,False,124,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*int faceDetectResultAge*/;																					//@<BlockInfo>jp.vstone.block.variable,928,32,928,32,False,123,break@</BlockInfo>
																														//@<EndOfBlock/>
		gender=0;																										//@<BlockInfo>jp.vstone.block.variable,992,32,992,32,False,122,break@</BlockInfo>
																														//@<EndOfBlock/>
		noDetectDuration=0;																								//@<BlockInfo>jp.vstone.block.variable,1056,32,1056,32,False,121,break@</BlockInfo>
																														//@<EndOfBlock/>
		detectDuration=0;																								//@<BlockInfo>jp.vstone.block.variable,1120,32,1120,32,False,120,break@</BlockInfo>
																														//@<EndOfBlock/>
		exist=true;																										//@<BlockInfo>jp.vstone.block.variable,1184,32,1184,32,False,119,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void workingChecker()																						//@<BlockInfo>jp.vstone.block.func,0,2720,1792,2720,False,158,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		time_string = CRobotUtil.getTimeString();																		//@<BlockInfo>jp.vstone.block.time.gettime,64,2720,64,2720,False,157,ロボット内のカレンダーより現在時刻を文字列で取得し、変数String time_stringに代入。@</BlockInfo>
																														//@<EndOfBlock/>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,304,2720,1728,2720,False,156,顔追従@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,368,2720,880,2720,False,155,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,432,2672,816,2672,False,142,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)2)
				{
																														//@<OutputChild>
					GlobalVariable.faceuser = GlobalVariable.robocam.getUser(GlobalVariable.faceresult);				//@<BlockInfo>jp.vstone.block.facedetect.user.get2,496,2624,752,2624,False,141,認識した顔の特徴を取得して、グローバル変数FaceUser faceuserに代入します。また、登録済みのユーザの場合、名前をグローバル変数String facenameに代入します。@</BlockInfo>

					if(GlobalVariable.faceuser != null)
					{
						if(GlobalVariable.faceuser.getName() != null) GlobalVariable.facename = GlobalVariable.faceuser.getName();
						else GlobalVariable.facename="";
						
																														//@<OutputChild>
							callName=(String)GlobalVariable.facename;														//@<BlockInfo>jp.vstone.block.calculater,560,2624,560,2624,False,139,@</BlockInfo>
																															//@<EndOfBlock/>
							System.out.println(callName + "を識別しました。");														//@<BlockInfo>jp.vstone.block.freeproc,624,2624,624,2624,False,138,@</BlockInfo>
							
							try{
							ConfigurationBuilder cb = new ConfigurationBuilder();
							cb.setDebugEnabled(true)
							  .setOAuthConsumerKey("amssqZdWo4YasEHpYacSnvLBL")
							  .setOAuthConsumerSecret("p1RjOH9z75rVXBDlPD4pfX2KV11S7glrZycxDptRgO5thDINkb")
							  .setOAuthAccessToken("4882733018-6r7fqkuAiWOtXGorBCX0eXbt3Kn6QezyW54H00d")
							  .setOAuthAccessTokenSecret("oTPnpb2asAsos7N4OWGZUeURrlPXBmn2TLcG3hk0o68Dg");
							
							TwitterFactory tf = new TwitterFactory(cb.build());
							
							Twitter tw = tf.getInstance();
							User user = tw.verifyCredentials();
							
							tw.updateStatus("[" + time_string + "]" + callName + "は研究室で作業を始めました。");
							}catch(TwitterException te){
							System.out.println(te);
							}
																															//@<EndOfBlock/>
							break;																							//@<BlockInfo>jp.vstone.block.break,688,2624,688,2624,False,137,break@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

					}
					else
					{
						
																														//@<OutputChild>
							System.out.println("識別できませんでした。");																//@<BlockInfo>jp.vstone.block.freeproc,624,2720,624,2720,False,140,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>

					}
																														//@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,992,2720,1664,2720,False,154,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				if(exist==false)																						//@<BlockInfo>jp.vstone.block.if,1056,2672,1600,2672,False,153,コメント@</BlockInfo>
				{
																														//@<OutputChild>
					detectDuration = GlobalVariable.robocam.getDetectDuration();										//@<BlockInfo>jp.vstone.block.facedetect.detectduration.get,1120,2672,1120,2672,False,148,顔が見えている場合、その累積時間を変数long detectDurationに返す。@</BlockInfo>	@<EndOfBlock/>
					CRobotUtil.wait((int)1000);																			//@<BlockInfo>jp.vstone.block.wait,1184,2672,1184,2672,False,147,コメント@</BlockInfo>	@<EndOfBlock/>
					if(detectDuration == 0){																			//@<BlockInfo>jp.vstone.block.freeproc,1248,2672,1248,2672,False,146,@</BlockInfo>
					System.out.println("いません");
					}else{
					System.out.println("みえてるじかん： " + detectDuration + "ms" );
					}
																														//@<EndOfBlock/>
					if(detectDuration>=30000)																			//@<BlockInfo>jp.vstone.block.if,1328,2576,1520,2576,False,145,コメント@</BlockInfo>
					{
																														//@<OutputChild>
						try{																							//@<BlockInfo>jp.vstone.block.freeproc,1392,2576,1392,2576,False,144,@</BlockInfo>
						ConfigurationBuilder cb = new ConfigurationBuilder();
						cb.setDebugEnabled(true)
						  .setOAuthConsumerKey("amssqZdWo4YasEHpYacSnvLBL")
						  .setOAuthConsumerSecret("p1RjOH9z75rVXBDlPD4pfX2KV11S7glrZycxDptRgO5thDINkb")
						  .setOAuthAccessToken("4882733018-6r7fqkuAiWOtXGorBCX0eXbt3Kn6QezyW54H00d")
						  .setOAuthAccessTokenSecret("oTPnpb2asAsos7N4OWGZUeURrlPXBmn2TLcG3hk0o68Dg");

						TwitterFactory tf = new TwitterFactory(cb.build());

						Twitter tw = tf.getInstance();
						User user = tw.verifyCredentials();

						time_string = CRobotUtil.getTimeString();
						tw.updateStatus("[" + time_string + "]" + callName + "は研究室で作業を再開しました。");
						}catch(TwitterException te){
						System.out.println(te);
						}
																														//@<EndOfBlock/>
						exist=(boolean)true;																			//@<BlockInfo>jp.vstone.block.calculater,1456,2576,1456,2576,False,143,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
					}
					else
					{
																														//@<OutputChild>
																														//@</OutputChild>
					}
																														//@<EndOfBlock/>
																														//@</OutputChild>
				}
				else
				{
																														//@<OutputChild>
					noDetectDuration = GlobalVariable.robocam.getNotDetectDuration();									//@<BlockInfo>jp.vstone.block.facedetect.nodetectduration.get,1120,2768,1120,2768,False,152,顔が見えていない場合、その累積時間を変数long noDetectDurationに返す。@</BlockInfo>	@<EndOfBlock/>
					CRobotUtil.wait((int)1000);																			//@<BlockInfo>jp.vstone.block.wait,1184,2768,1184,2768,False,151,コメント@</BlockInfo>	@<EndOfBlock/>
					if(noDetectDuration == 0){																			//@<BlockInfo>jp.vstone.block.freeproc,1248,2768,1248,2768,False,150,@</BlockInfo>
					System.out.println("みえてます");
					}else{
					System.out.println("みえてないじかん： " + noDetectDuration + "ms" );
					}
																														//@<EndOfBlock/>
					if(noDetectDuration>=30000)																			//@<BlockInfo>jp.vstone.block.if,1328,2768,1520,2768,False,149,コメント@</BlockInfo>
					{
																														//@<OutputChild>
						try{																							//@<BlockInfo>jp.vstone.block.freeproc,1392,2768,1392,2768,False,160,@</BlockInfo>
						ConfigurationBuilder cb = new ConfigurationBuilder();
						cb.setDebugEnabled(true)
						  .setOAuthConsumerKey("amssqZdWo4YasEHpYacSnvLBL")
						  .setOAuthConsumerSecret("p1RjOH9z75rVXBDlPD4pfX2KV11S7glrZycxDptRgO5thDINkb")
						  .setOAuthAccessToken("4882733018-6r7fqkuAiWOtXGorBCX0eXbt3Kn6QezyW54H00d")
						  .setOAuthAccessTokenSecret("oTPnpb2asAsos7N4OWGZUeURrlPXBmn2TLcG3hk0o68Dg");

						TwitterFactory tf = new TwitterFactory(cb.build());

						Twitter tw = tf.getInstance();
						User user = tw.verifyCredentials();

						time_string = CRobotUtil.getTimeString();
						tw.updateStatus("[" + time_string + "]" + callName + "は離席中です。");
						}catch(TwitterException te){
						System.out.println(te);
						}
																														//@<EndOfBlock/>
						exist=(boolean)false;																			//@<BlockInfo>jp.vstone.block.calculater,1456,2768,1456,2768,False,159,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
					}
					else
					{
																														//@<OutputChild>
																														//@</OutputChild>
					}
																														//@<EndOfBlock/>
																														//@</OutputChild>
				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>


		}finally{
			GlobalVariable.robocam.StopFaceTraking();
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
