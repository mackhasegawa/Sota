//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.camera.*;
import	jp.vstone.camera.FaceDetectLib.*;
import	jp.vstone.sotatalk.SpeechRecog.*;
import	java.awt.Color;

public class face
{

	public int addFaceuserErrSayInterval;
	public String faceName;
	public String date_string;
	public String time_string;
	public CRobotPose pose;
	public void faceRegistration()																						//@<BlockInfo>jp.vstone.block.func,16,400,1072,400,False,13,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,80,400,1008,400,False,12,tracking@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,144,400,944,400,False,11,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,208,352,880,352,False,10,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)2)
				{
																														//@<OutputChild>
					GlobalVariable.faceuser = GlobalVariable.robocam.getUser(GlobalVariable.faceresult);				//@<BlockInfo>jp.vstone.block.facedetect.user.get2,288,192,800,192,False,8,認識した顔の特徴を取得して、グローバル変数FaceUser faceuserに代入します。また、登録済みのユーザの場合、名前をグローバル変数String facenameに代入します。@</BlockInfo>

					if(GlobalVariable.faceuser != null)
					{
						if(GlobalVariable.faceuser.getName() != null) GlobalVariable.facename = GlobalVariable.faceuser.getName();
						else GlobalVariable.facename="";
						
																														//@<OutputChild>
							if(!GlobalVariable.faceuser.isNewUser())														//@<BlockInfo>jp.vstone.block.facedetect.user.isknow,352,144,736,144,False,6,グローバル変数FaceUser faceuserに記録された顔が登録された顔であるか@</BlockInfo>
							{
																															//@<OutputChild>
								CPlayWave.PlayWave("resource/MEN.wav",false);												//@<BlockInfo>jp.vstone.block.sound2,448,112,448,112,False,2,コメント@</BlockInfo>	@<EndOfBlock/>
								break;																						//@<BlockInfo>jp.vstone.block.break,512,112,512,112,False,1,break@</BlockInfo>	@<EndOfBlock/>
																															//@</OutputChild>
							
							}else
							{
																															//@<OutputChild>
								if(GlobalVariable.faceuser!=null)															//@<BlockInfo>jp.vstone.block.facedetect.user.add,416,192,672,192,False,5,@</BlockInfo>
								{
									GlobalVariable.faceuser.setName((String)faceName);
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
									CPlayWave.PlayWave("resource/OK.wav",false);											//@<BlockInfo>jp.vstone.block.sound2,544,192,544,192,False,4,コメント@</BlockInfo>	@<EndOfBlock/>
									break;																					//@<BlockInfo>jp.vstone.block.break,608,192,608,192,False,3,break@</BlockInfo>	@<EndOfBlock/>
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
																															//@<EndOfBlock/>
																																//@</OutputChild>

					}
					else
					{
						
																														//@<OutputChild>
							CPlayWave.PlayWave("resource/NG.wav",false);													//@<BlockInfo>jp.vstone.block.sound2,368,368,368,368,False,7,コメント@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

					}
																														//@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
					CPlayWave.PlayWave("resource/NG.wav",false);														//@<BlockInfo>jp.vstone.block.sound2,512,448,512,448,False,9,コメント@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>


		}
		GlobalVariable.robocam.StopFaceTraking();

																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public face()																										//@<BlockInfo>jp.vstone.block.func.constructor,16,16,720,16,False,19,@</BlockInfo>
	{
																														//@<OutputChild>
		addFaceuserErrSayInterval=0;																					//@<BlockInfo>jp.vstone.block.variable,96,16,96,16,False,18,break@</BlockInfo>
																														//@<EndOfBlock/>
		faceName="まつもとくん";																								//@<BlockInfo>jp.vstone.block.variable,160,16,160,16,False,17,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String date_string*/;																							//@<BlockInfo>jp.vstone.block.variable,288,16,288,16,False,16,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String time_string*/;																							//@<BlockInfo>jp.vstone.block.variable,352,16,352,16,False,15,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*CRobotPose pose*/;																							//@<BlockInfo>jp.vstone.block.variable,416,16,416,16,False,14,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void takePhoto()																								//@<BlockInfo>jp.vstone.block.func,32,1264,352,1264,False,24,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		date_string = CRobotUtil.getDateString();																		//@<BlockInfo>jp.vstone.block.time.getdate,96,1264,96,1264,False,23,ロボット内のカレンダーより現在年月日を文字列で取得し、変数String date_stringに代入。@</BlockInfo>
																														//@<EndOfBlock/>
		time_string = CRobotUtil.getTimeString();																		//@<BlockInfo>jp.vstone.block.time.gettime,160,1264,160,1264,False,22,ロボット内のカレンダーより現在時刻を文字列で取得し、変数String time_stringに代入。@</BlockInfo>
																														//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.facedetect.stillpicture,224,1264,224,1264,False,21,still@</BlockInfo>
			String filepath = "/var/sota/photo/";
			filepath += (String)callName+" "+date_string+" "+time_string;
			boolean isTrakcing=GlobalVariable.robocam.isAliveFaceDetectTask();
			if(isTrakcing) GlobalVariable.robocam.StopFaceTraking();
			GlobalVariable.robocam.initStill(new CameraCapture(CameraCapture.CAP_IMAGE_SIZE_5Mpixel, CameraCapture.CAP_FORMAT_MJPG));
			GlobalVariable.robocam.StillPicture(filepath);

			CRobotUtil.Log("stillpicture","save picthre file to \"" + filepath +"\"");
			if(isTrakcing) GlobalVariable.robocam.StartFaceTraking();
		}																												//@<EndOfBlock/>
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");																//@<BlockInfo>jp.vstone.block.freeproc,288,1264,288,1264,False,20,@</BlockInfo>
		System.out.println(callName + "を撮影しました。");
		System.out.println("プログラムを終了します。");
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void callName()																								//@<BlockInfo>jp.vstone.block.func,48,1104,1424,1104,False,42,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,320,1104,1360,1104,False,41,tracking@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,384,1104,1296,1104,False,40,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,448,1056,1232,1056,False,39,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)2)
				{
																														//@<OutputChild>
					GlobalVariable.faceuser = GlobalVariable.robocam.getUser(GlobalVariable.faceresult);				//@<BlockInfo>jp.vstone.block.facedetect.user.get2,512,1008,1168,1008,False,37,認識した顔の特徴を取得して、グローバル変数FaceUser faceuserに代入します。また、登録済みのユーザの場合、名前をグローバル変数String facenameに代入します。@</BlockInfo>

					if(GlobalVariable.faceuser != null)
					{
						if(GlobalVariable.faceuser.getName() != null) GlobalVariable.facename = GlobalVariable.faceuser.getName();
						else GlobalVariable.facename="";
						
																														//@<OutputChild>
							if(!GlobalVariable.faceuser.isNewUser())														//@<BlockInfo>jp.vstone.block.facedetect.user.isknow,576,960,1104,960,False,35,グローバル変数FaceUser faceuserに記録された顔が登録された顔であるか@</BlockInfo>
							{
																															//@<OutputChild>
								callName=(String)GlobalVariable.facename;													//@<BlockInfo>jp.vstone.block.calculater,640,960,640,960,False,33,@</BlockInfo>
																															//@<EndOfBlock/>
									System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");											//@<BlockInfo>jp.vstone.block.freeproc,704,960,704,960,False,32,@</BlockInfo>
									System.out.println(callName + "を認識しました。");
									System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-");
																															//@<EndOfBlock/>
								switch((String)callName)																	//@<BlockInfo>jp.vstone.block.switch,784,560,944,560,False,31,@</BlockInfo>
								{
									case (String)"まきのくん":
									{
																															//@<OutputChild>
										CPlayWave.PlayWave("resource/CallA.wav",false);											//@<BlockInfo>jp.vstone.block.sound2,864,560,864,560,False,25,コメント@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
										break;
									}
									case (String)"かわさきくん":
									{
																															//@<OutputChild>
										CPlayWave.PlayWave("resource/CallB.wav",false);											//@<BlockInfo>jp.vstone.block.sound2,864,656,864,656,False,26,コメント@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
										break;
									}
									case (String)"しまだくん":
									{
																															//@<OutputChild>
										CPlayWave.PlayWave("resource/CallC.wav",false);											//@<BlockInfo>jp.vstone.block.sound2,864,752,864,752,False,27,コメント@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
										break;
									}
									case (String)"まつもとくん":
									{
																															//@<OutputChild>
										CPlayWave.PlayWave("resource/CallD.wav",false);											//@<BlockInfo>jp.vstone.block.sound2,864,848,864,848,False,28,コメント@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
										break;
									}
							
								}																							//@<EndOfBlock/>
								takePhoto();																				//@<BlockInfo>jp.vstone.block.callfunc.base,1008,704,1008,704,False,30,@</BlockInfo>	@<EndOfBlock/>
								break;																						//@<BlockInfo>jp.vstone.block.break,1072,704,1072,704,False,29,break@</BlockInfo>	@<EndOfBlock/>
																															//@</OutputChild>
							
							}else
							{
																															//@<OutputChild>
								CPlayWave.PlayWave("resource/NG.wav",false);												//@<BlockInfo>jp.vstone.block.sound2,704,1056,704,1056,False,34,コメント@</BlockInfo>	@<EndOfBlock/>
																															//@</OutputChild>
							
							}
																															//@<EndOfBlock/>
																																//@</OutputChild>

					}
					else
					{
						
																														//@<OutputChild>
							CPlayWave.PlayWave("resource/NG.wav",false);													//@<BlockInfo>jp.vstone.block.sound2,640,1104,640,1104,False,36,コメント@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

					}
																														//@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
					CPlayWave.PlayWave("resource/NG.wav",false);														//@<BlockInfo>jp.vstone.block.sound2,576,1152,576,1152,False,38,コメント@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>


		}
		GlobalVariable.robocam.StopFaceTraking();

																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
