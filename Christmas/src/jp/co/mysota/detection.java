//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.camera.*;
import	java.awt.Color;

public class detection
{

	public CRobotPose pose;
	public jp.co.mysota.action action;
	public detection()																									//@<BlockInfo>jp.vstone.block.func.constructor,0,0,192,0,False,3,@</BlockInfo>
	{
																														//@<OutputChild>
		/*CRobotPose pose*/;																							//@<BlockInfo>jp.vstone.block.variable,64,0,64,0,False,2,break@</BlockInfo>
																														//@<EndOfBlock/>
		action=new jp.co.mysota.action();																				//@<BlockInfo>jp.vstone.block.variable,128,0,128,0,False,1,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void smileDetect()																							//@<BlockInfo>jp.vstone.block.func,0,160,832,160,False,10,@</BlockInfo>
	{
																														//@<OutputChild>
		GlobalVariable.motion.ServoOn();																				//@<BlockInfo>jp.vstone.block.motoron,64,160,64,160,False,9,ON@</BlockInfo>	@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,128,160,128,160,False,8,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,1000);
		CRobotUtil.wait(1000);																							//@<EndOfBlock/>
		GlobalVariable.robocam.setEnableFaceSearch(true);																//@<BlockInfo>jp.vstone.block.facedetect.detect,192,160,704,160,False,7,detect@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceDetect();
		{
			GlobalVariable.detectCount=0;

																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,160,240,672,240,False,5,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				pose = new CRobotPose();																				//@<BlockInfo>jp.vstone.block.pose,224,240,224,240,False,4,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{0,-900,0,900,0,0,0,0}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{0,-255,0,0,0,255,0,0,255}
								);
				GlobalVariable.motion.play(pose,1000);
				CRobotUtil.wait(1000);																					//@<EndOfBlock/>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,288,192,608,192,False,15,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)0)
				{
																														//@<OutputChild>
					if(GlobalVariable.faceresult.getSmile()>=(int)60)													//@<BlockInfo>jp.vstone.block.facedetect.smile,352,144,544,144,False,14,@</BlockInfo>
					{
																														//@<OutputChild>
						pose = new CRobotPose();																		//@<BlockInfo>jp.vstone.block.pose,416,144,416,144,False,12,コメント@</BlockInfo>
						pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
										new Short[]{0,-900,0,900,0,0,0,0}
										);
						pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
										new Short[]{100,100,100,100,100,100,100,100}
										);
						pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
										new Short[]{0,-255,0,180,80,0,180,80,0}
										);
						GlobalVariable.motion.play(pose,1000);
						CRobotUtil.wait(1000);																			//@<EndOfBlock/>
						break;																							//@<BlockInfo>jp.vstone.block.break,480,144,480,144,False,11,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

					}else
					{
																														//@<OutputChild>
						pose = new CRobotPose();																		//@<BlockInfo>jp.vstone.block.pose,448,240,448,240,False,13,コメント@</BlockInfo>
						pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
										new Short[]{0,-900,0,900,0,0,0,0}
										);
						pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
										new Short[]{100,100,100,100,100,100,100,100}
										);
						pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
										new Short[]{0,-255,0,255,0,0,255,0,0}
										);
						GlobalVariable.motion.play(pose,1000);
						CRobotUtil.wait(1000);																			//@<EndOfBlock/>
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

		}
		GlobalVariable.robocam.StopFaceDetect();

																														//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,768,160,768,160,False,6,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,1000);
		CRobotUtil.wait(1000);																							//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

}
