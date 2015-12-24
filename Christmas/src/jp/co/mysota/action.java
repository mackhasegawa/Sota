//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	java.awt.Color;
import	jp.vstone.camera.*;

public class action
{

	public CRobotPose pose;
	public action()																										//@<BlockInfo>jp.vstone.block.func.constructor,0,0,128,0,False,2,@</BlockInfo>
	{
																														//@<OutputChild>
		/*CRobotPose pose*/;																							//@<BlockInfo>jp.vstone.block.variable,64,0,64,0,False,1,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void ShakeHands()																							//@<BlockInfo>jp.vstone.block.func,32,240,576,240,False,12,@</BlockInfo>
	{
																														//@<OutputChild>
		GlobalVariable.motion.ServoOn();																				//@<BlockInfo>jp.vstone.block.motoron,96,240,96,240,False,11,ON@</BlockInfo>	@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,160,240,160,240,False,10,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,270,310,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,1000);
		CRobotUtil.wait(1000);																							//@<EndOfBlock/>
		CRobotUtil.wait((int)2000);																						//@<BlockInfo>jp.vstone.block.wait,224,240,224,240,False,9,コメント@</BlockInfo>	@<EndOfBlock/>
		GlobalVariable.robocam.setEnableFaceSearch(true);																//@<BlockInfo>jp.vstone.block.facedetect.traking,48,320,368,320,False,8,tracking@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			for(int i=0;i<(int)2;i++)																					//@<BlockInfo>jp.vstone.block.for,112,320,304,320,False,5,コメント@</BlockInfo>
			{
																														//@<OutputChild>
				pose = new CRobotPose();																				//@<BlockInfo>jp.vstone.block.pose,176,320,176,320,False,4,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{0,-900,0,-100,310,0,0,0}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{0,-255,0,180,80,0,180,80,0}
								);
				GlobalVariable.motion.play(pose,1000);
				CRobotUtil.wait(1000);																					//@<EndOfBlock/>
				pose = new CRobotPose();																				//@<BlockInfo>jp.vstone.block.pose,240,320,240,320,False,3,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{0,-900,0,570,310,0,0,0}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{0,-255,0,180,80,0,180,80,0}
								);
				GlobalVariable.motion.play(pose,1000);
				CRobotUtil.wait(1000);																					//@<EndOfBlock/>
																														//@</OutputChild>
			}																											//@<EndOfBlock/>
																														//@</OutputChild>


		}
		GlobalVariable.robocam.StopFaceTraking();

																														//@<EndOfBlock/>
		CRobotUtil.wait((int)2500);																						//@<BlockInfo>jp.vstone.block.wait,432,320,432,320,False,7,コメント@</BlockInfo>	@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,496,320,496,320,False,6,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,0,80,0,0,80,0}
						);
		GlobalVariable.motion.play(pose,1000);
		CRobotUtil.wait(1000);																							//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void HandsUp()																								//@<BlockInfo>jp.vstone.block.func,32,128,288,128,False,16,@</BlockInfo>
	{
																														//@<OutputChild>
		GlobalVariable.motion.ServoOn();																				//@<BlockInfo>jp.vstone.block.motoron,96,128,96,128,False,15,ON@</BlockInfo>	@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,160,128,160,128,False,14,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{-11,-546,-274,546,274,3,-46,-7}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,0,255,0,0,255,0}
						);
		GlobalVariable.motion.play(pose,1000);
		CRobotUtil.wait(1000);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,224,128,224,128,False,13,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{-8,466,-274,-466,274,4,-46,-7}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,0,255,0,0,255,0}
						);
		GlobalVariable.motion.play(pose,1000);
		CRobotUtil.wait(1000);																							//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void Walking()																								//@<BlockInfo>jp.vstone.block.func,32,432,544,432,False,23,@</BlockInfo>
	{
																														//@<OutputChild>
		GlobalVariable.motion.ServoOn();																				//@<BlockInfo>jp.vstone.block.motoron,96,432,96,432,False,22,ON@</BlockInfo>	@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,160,432,160,432,False,21,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,1500);
		CRobotUtil.wait(1500);																							//@<EndOfBlock/>
		for(int i=0;i<(int)3;i++)																						//@<BlockInfo>jp.vstone.block.for,224,432,416,432,False,20,コメント@</BlockInfo>
		{
																														//@<OutputChild>
			pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,288,432,288,432,False,18,コメント@</BlockInfo>
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-9,-1376,-283,321,194,3,-46,-8}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			GlobalVariable.motion.play(pose,1500);
			CRobotUtil.wait(1500);																						//@<EndOfBlock/>
			pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,352,432,352,432,False,17,コメント@</BlockInfo>
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{9,-321,-194,1376,283,-3,-46,8}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			GlobalVariable.motion.play(pose,1500);
			CRobotUtil.wait(1500);																						//@<EndOfBlock/>
																														//@</OutputChild>
		}																												//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,480,432,480,432,False,19,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,1500);
		CRobotUtil.wait(1500);																							//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

}
