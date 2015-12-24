package main;
//本ソースは、VstoneMagicから自動生成されました。
//本ソースの内容を書き換えると、正しくプログラムが実行されなくなる可能性があります。

import jp.co.mysota.mymain;
import jp.vstone.RobotLib.*;
import jp.vstone.camera.*;


public class main
{
	public static void main(String[] args)
	{
		if(GlobalVariable.mem.Connect())
		{
			GlobalVariable.motion.InitRobot_Sota();

			jp.co.mysota.mymain mymain = new jp.co.mysota.mymain();
			mymain.main();
		}
	}

	public static class GlobalVariable
	{
		public static CRobotMem mem = new CRobotMem();
		public static CSotaMotion motion = new CSotaMotion(mem);
		public static boolean TRUE = true;
		public static Object recvReturnValue;
		public static FaceDetectResult faceresult;
		public static CRoboCamera robocam = new CRoboCamera("/dev/video0",motion);
		public static int detectCount = 0;
	}


}

