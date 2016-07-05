//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.camera.*;
import	jp.vstone.camera.FaceDetectLib.*;
import	jp.vstone.sotatalk.SpeechRecog.*;

public class face
{

	public int addFaceuserErrSayInterval;
	public String faceName;
	public String callName;
	public String date_string;
	public String time_string;
	public void callName()																								//@<BlockInfo>jp.vstone.block.func,32,928,1200,928,False,16,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,96,928,1136,928,False,15,tracking@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,160,928,1072,928,False,14,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,224,880,1008,880,False,13,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)2)
				{
																														//@<OutputChild>
					GlobalVariable.faceuser = GlobalVariable.robocam.getUser(GlobalVariable.faceresult);				//@<BlockInfo>jp.vstone.block.facedetect.user.get2,288,832,944,832,False,11,認識した顔の特徴を取得して、グローバル変数FaceUser faceuserに代入します。また、登録済みのユーザの場合、名前をグローバル変数String facenameに代入します。@</BlockInfo>

					if(GlobalVariable.faceuser != null)
					{
						if(GlobalVariable.faceuser.getName() != null) GlobalVariable.facename = GlobalVariable.faceuser.getName();
						else GlobalVariable.facename="";
						
																														//@<OutputChild>
							if(!GlobalVariable.faceuser.isNewUser())														//@<BlockInfo>jp.vstone.block.facedetect.user.isknow,352,784,880,784,False,9,グローバル変数FaceUser faceuserに記録された顔が登録された顔であるか@</BlockInfo>
							{
																															//@<OutputChild>
								callName=(String)GlobalVariable.facename;													//@<BlockInfo>jp.vstone.block.calculater,416,784,416,784,False,7,@</BlockInfo>
																															//@<EndOfBlock/>
								switch((String)callName)																	//@<BlockInfo>jp.vstone.block.switch,496,624,656,624,False,6,@</BlockInfo>
								{
									case (String)"まきのくん":
									{
																															//@<OutputChild>
										CPlayWave.PlayWave("resource/CallA.wav",false);											//@<BlockInfo>jp.vstone.block.sound2,576,624,576,624,False,1,コメント@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
										break;
									}
									case (String)"かわさきくん":
									{
																															//@<OutputChild>
										CPlayWave.PlayWave("resource/CallB.wav",false);											//@<BlockInfo>jp.vstone.block.sound2,576,720,576,720,False,2,コメント@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
										break;
									}
									case (String)"しまだくん":
									{
																															//@<OutputChild>
										CPlayWave.PlayWave("resource/CallC.wav",false);											//@<BlockInfo>jp.vstone.block.sound2,576,816,576,816,False,3,コメント@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
										break;
									}
							
								}																							//@<EndOfBlock/>
								takePhoto();																				//@<BlockInfo>jp.vstone.block.callfunc.base,720,720,720,720,False,5,@</BlockInfo>	@<EndOfBlock/>
								break;																						//@<BlockInfo>jp.vstone.block.break,800,720,800,720,False,4,break@</BlockInfo>	@<EndOfBlock/>
																															//@</OutputChild>
							
							}else
							{
																															//@<OutputChild>
								CPlayWave.PlayWave("resource/NG.wav",false);												//@<BlockInfo>jp.vstone.block.sound2,480,880,480,880,False,8,コメント@</BlockInfo>	@<EndOfBlock/>
																															//@</OutputChild>
							
							}
																															//@<EndOfBlock/>
																																//@</OutputChild>

					}
					else
					{
						
																														//@<OutputChild>
							CPlayWave.PlayWave("resource/NG.wav",false);													//@<BlockInfo>jp.vstone.block.sound2,416,928,416,928,False,10,コメント@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

					}
																														//@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
					CPlayWave.PlayWave("resource/NG.wav",false);														//@<BlockInfo>jp.vstone.block.sound2,352,976,352,976,False,12,コメント@</BlockInfo>	@<EndOfBlock/>
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
	public void faceRegistration()																						//@<BlockInfo>jp.vstone.block.func,16,400,1072,400,False,29,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,80,400,1008,400,False,28,tracking@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,144,400,944,400,False,27,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,208,352,880,352,False,26,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)2)
				{
																														//@<OutputChild>
					GlobalVariable.faceuser = GlobalVariable.robocam.getUser(GlobalVariable.faceresult);				//@<BlockInfo>jp.vstone.block.facedetect.user.get2,288,192,800,192,False,24,認識した顔の特徴を取得して、グローバル変数FaceUser faceuserに代入します。また、登録済みのユーザの場合、名前をグローバル変数String facenameに代入します。@</BlockInfo>

					if(GlobalVariable.faceuser != null)
					{
						if(GlobalVariable.faceuser.getName() != null) GlobalVariable.facename = GlobalVariable.faceuser.getName();
						else GlobalVariable.facename="";
						
																														//@<OutputChild>
							if(!GlobalVariable.faceuser.isNewUser())														//@<BlockInfo>jp.vstone.block.facedetect.user.isknow,352,144,736,144,False,22,グローバル変数FaceUser faceuserに記録された顔が登録された顔であるか@</BlockInfo>
							{
																															//@<OutputChild>
								CPlayWave.PlayWave("resource/MEN.wav",false);												//@<BlockInfo>jp.vstone.block.sound2,448,112,448,112,False,18,コメント@</BlockInfo>	@<EndOfBlock/>
								break;																						//@<BlockInfo>jp.vstone.block.break,512,112,512,112,False,17,break@</BlockInfo>	@<EndOfBlock/>
																															//@</OutputChild>
							
							}else
							{
																															//@<OutputChild>
								if(GlobalVariable.faceuser!=null)															//@<BlockInfo>jp.vstone.block.facedetect.user.add,416,192,672,192,False,21,@</BlockInfo>
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
									CPlayWave.PlayWave("resource/OK.wav",false);											//@<BlockInfo>jp.vstone.block.sound2,544,192,544,192,False,20,コメント@</BlockInfo>	@<EndOfBlock/>
									break;																					//@<BlockInfo>jp.vstone.block.break,608,192,608,192,False,19,break@</BlockInfo>	@<EndOfBlock/>
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
							CPlayWave.PlayWave("resource/NG.wav",false);													//@<BlockInfo>jp.vstone.block.sound2,368,368,368,368,False,23,コメント@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

					}
																														//@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
					CPlayWave.PlayWave("resource/NG.wav",false);														//@<BlockInfo>jp.vstone.block.sound2,512,448,512,448,False,25,コメント@</BlockInfo>	@<EndOfBlock/>
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
	public face()																										//@<BlockInfo>jp.vstone.block.func.constructor,16,16,656,16,False,35,@</BlockInfo>
	{
																														//@<OutputChild>
		addFaceuserErrSayInterval=0;																					//@<BlockInfo>jp.vstone.block.variable,96,16,96,16,False,34,break@</BlockInfo>
																														//@<EndOfBlock/>
		faceName="しまだくん";																								//@<BlockInfo>jp.vstone.block.variable,160,16,160,16,False,33,break@</BlockInfo>
																														//@<EndOfBlock/>
		callName=null;																									//@<BlockInfo>jp.vstone.block.variable,224,16,224,16,False,32,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String date_string*/;																							//@<BlockInfo>jp.vstone.block.variable,288,16,288,16,False,31,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String time_string*/;																							//@<BlockInfo>jp.vstone.block.variable,352,16,352,16,False,30,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void takePhoto()																								//@<BlockInfo>jp.vstone.block.func,16,1088,272,1088,False,38,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		date_string = CRobotUtil.getDateString();																		//@<BlockInfo>jp.vstone.block.time.getdate,80,1088,80,1088,False,37,ロボット内のカレンダーより現在年月日を文字列で取得し、変数String date_stringに代入。@</BlockInfo>
																														//@<EndOfBlock/>
		time_string = CRobotUtil.getTimeString();																		//@<BlockInfo>jp.vstone.block.time.gettime,144,1088,144,1088,False,36,ロボット内のカレンダーより現在時刻を文字列で取得し、変数String time_stringに代入。@</BlockInfo>
																														//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.facedetect.stillpicture,208,1088,208,1088,False,39,still@</BlockInfo>
			String filepath = "/var/sota/photo/";
			filepath += (String)callName+" "+date_string+" "+time_string;
			boolean isTrakcing=GlobalVariable.robocam.isAliveFaceDetectTask();
			if(isTrakcing) GlobalVariable.robocam.StopFaceTraking();
			GlobalVariable.robocam.initStill(new CameraCapture(CameraCapture.CAP_IMAGE_SIZE_5Mpixel, CameraCapture.CAP_FORMAT_MJPG));
			GlobalVariable.robocam.StillPicture(filepath);

			CRobotUtil.Log("stillpicture","save picthre file to \"" + filepath +"\"");
			if(isTrakcing) GlobalVariable.robocam.StartFaceTraking();
		}																												//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
