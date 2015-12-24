//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	java.awt.Color;
import	jp.vstone.camera.*;

public class mymain
{

	public CRobotPose pose;
	public jp.co.mysota.action action;
	public jp.co.mysota.detection detection;
	public jp.co.mysota.Christmas Christmas;
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,32,352,32,False,1,@</BlockInfo>
	{
																														//@<OutputChild>
		/*CRobotPose pose*/;																							//@<BlockInfo>jp.vstone.block.variable,96,32,96,32,False,2,break@</BlockInfo>
																														//@<EndOfBlock/>
		action=new jp.co.mysota.action();																				//@<BlockInfo>jp.vstone.block.variable,160,32,160,32,False,3,break@</BlockInfo>
																														//@<EndOfBlock/>
		detection=new jp.co.mysota.detection();																			//@<BlockInfo>jp.vstone.block.variable,224,32,224,32,False,4,break@</BlockInfo>
																														//@<EndOfBlock/>
		Christmas=new jp.co.mysota.Christmas();																			//@<BlockInfo>jp.vstone.block.variable,288,32,288,32,False,5,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	/*
	action.ShakeHands();																								//@<BlockInfo>jp.vstone.block.callfunc.base,96,240,96,240,False,6,@</BlockInfo>	@<EndOfBlock/>

	*/

	//@<Separate/>
	/*
	action.Walking();																									//@<BlockInfo>jp.vstone.block.callfunc.base,256,240,256,240,False,7,@</BlockInfo>	@<EndOfBlock/>

	*/

	//@<Separate/>
	/*
	action.HandsUp();																									//@<BlockInfo>jp.vstone.block.callfunc.base,176,240,176,240,False,8,@</BlockInfo>	@<EndOfBlock/>

	*/

	//@<Separate/>
	/*
	detection.smileDetect();																							//@<BlockInfo>jp.vstone.block.callfunc.base,96,320,96,320,False,9,@</BlockInfo>	@<EndOfBlock/>

	*/

	//@<Separate/>
	/*
	pose = new CRobotPose();																							//@<BlockInfo>jp.vstone.block.pose,384,608,384,608,False,10,left up@</BlockInfo>
	pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
					new Short[]{0,300,-400,500,850,220,50,0}
					);
	pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
					new Short[]{100,100,100,100,100,100,100,100}
					);
	pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
					new Short[]{0,-255,0,0,80,0,0,80,0}
					);
	GlobalVariable.motion.play(pose,1000);
	CRobotUtil.wait(1000);																								//@<EndOfBlock/>

	*/

	//@<Separate/>
	/*
	pose = new CRobotPose();																							//@<BlockInfo>jp.vstone.block.pose,464,608,464,608,False,11,left up@</BlockInfo>
	pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
					new Short[]{0,-500,-850,-300,400,-220,50,0}
					);
	pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
					new Short[]{100,100,100,100,100,100,100,100}
					);
	pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
					new Short[]{0,-255,0,0,80,0,0,80,0}
					);
	GlobalVariable.motion.play(pose,1000);
	CRobotUtil.wait(1000);																								//@<EndOfBlock/>

	*/

	//@<Separate/>
	/*
	GlobalVariable.motion.ServoOff();																					//@<BlockInfo>jp.vstone.block.motoroff,224,432,224,432,False,12,off@</BlockInfo>	@<EndOfBlock/>

	*/

	//@<Separate/>
	public void main()																									//@<BlockInfo>jp.vstone.block.func,32,144,688,144,False,13,コメント@</BlockInfo>
	{
																														//@<OutputChild>
		GlobalVariable.motion.ServoOn();																				//@<BlockInfo>jp.vstone.block.motoron,96,144,96,144,False,14,ON@</BlockInfo>	@<EndOfBlock/>
		Christmas.Christmas();																							//@<BlockInfo>jp.vstone.block.callfunc.base,160,144,160,144,False,15,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	/*
	Christmas.test();																									//@<BlockInfo>jp.vstone.block.callfunc.base,176,320,176,320,False,16,@</BlockInfo>	@<EndOfBlock/>

	*/

}
