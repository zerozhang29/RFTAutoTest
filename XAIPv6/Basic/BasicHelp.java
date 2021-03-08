package Basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

//import Basic.SendMail.SendMail;

import com.rational.test.ft.object.interfaces.BrowserTestObject;
import com.rational.test.ft.object.interfaces.GuiTestObject;
import com.rational.test.ft.object.interfaces.IWindow;
import com.rational.test.ft.object.interfaces.StatelessGuiSubitemTestObject;
import com.rational.test.ft.object.interfaces.TestObject;
import com.rational.test.ft.object.interfaces.TextGuiTestObject;
import com.rational.test.ft.object.interfaces.ToggleGUITestObject;
import com.rational.test.ft.script.RationalTestScript;
import com.rational.test.ft.value.MethodInfo;

/**
 * Description   : Super class for script helper
 * 
 * @author zhangyu
 * @since  7�� 27, 2016
 */
public abstract class BasicHelp extends RationalTestScript
{
	//TODO Insert shared functionality here
	public void LauchCanTV() {
		callScript("Basic.Login.LauchCanTV");
	}
	
	public void Login(String user, String password)
	{
		Object[] LoginArgs = new Object[2];
		LoginArgs[0] = user;
		LoginArgs[1] = password;
		callScript("Basic.Login.Login", LoginArgs);
		sleep(1);
	}
	
	public void Login() {
		callScript("Basic.Login.Login");
	}
	
	public void LauchUAT_YS() {
		callScript("Basic.Login.LauchUAT_YS");
	}

	public void LaunchYeahSite() {
		callScript("Basic.Login.LauchYeahSite");
	}

	public void CloseYeahSite() {
		callScript("Basic.Logout.CloseYeahSite");
	}

	public void Login1() {
		callScript("Basic.LoginSuites1");
	}

	public void Login2() {
		callScript("Basic.LoginSuites2");
	}

	public void Login3() {
		callScript("Basic.LoginSuites3");
	}

	public void DelCancle() {
		callScript("Basic.DelCancle");
	}

	public void DelCofirm() {
		callScript("Basic.DelCofirm");
	}

	protected Object[] searchItem(int searchBy, String keyword)
	{
		Object[] searchArgs = new Object[2];
		searchArgs[0] = searchBy;
		searchArgs[1] = keyword;
		return searchArgs;
	}

	public static void CloseAllBrowsers() {

		try {

			Runtime.getRuntime().exec("cmd /c tskill iexplore");

		} catch (IOException e) {

			System.out.println(e.toString());
		}
	}

	public static void KillIE() {
		// TODO �Զ����ɵķ������
		try {
			String[] cmd = { "tasklist" };
			Process proc = Runtime.getRuntime().exec(cmd);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					proc.getInputStream()));
			String string_Temp = in.readLine();
			if (string_Temp != null) {
				System.out.println(string_Temp); 
				if (string_Temp.indexOf("iexplore") != -1)
				Runtime.getRuntime().exec("cmd /c tskill iexplore");
       		    string_Temp = in.readLine();
			}
		} catch (Exception e) {
		}
	}
	
	public static void printMethods(TestObject to) {
		MethodInfo[] m = to.getMethods();
		for (int i = 0; i < m.length; ++i) {
			System.out.println("Method" + i + ":name=" + m[i].getName()
					+ ":signature" + m[i].getSignature());
		}

	}

	public GuiTestObject getGuiObject(String P1, String V1, String P2, String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		GuiTestObject oObject = null;

		if (objects.length > 0) {
			oObject = (GuiTestObject) objects[0];
		}
		return oObject;
	}

	
	public GuiTestObject get2ndGuiObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		GuiTestObject oObject = null;

		if (objects.length > 0) {
			oObject = (GuiTestObject) objects[1];
		}
		return oObject;
	}

	public GuiTestObject get3rdGuiObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		GuiTestObject oObject = null;

		if (objects.length > 0) {
			oObject = (GuiTestObject) objects[2];
		}
		return oObject;
	}	

	public TextGuiTestObject getTextGuiObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		TextGuiTestObject oObject = null;

		if (objects.length > 0) {
			oObject = (TextGuiTestObject) objects[0];
		}
		return oObject;
	}
	
	public StatelessGuiSubitemTestObject getTabObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		StatelessGuiSubitemTestObject oObject = null;

		if (objects.length > 0) {
			oObject = (StatelessGuiSubitemTestObject) objects[0];
		}
		return oObject;
	}
	
	public StatelessGuiSubitemTestObject get2TabObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		StatelessGuiSubitemTestObject oObject = null;

		if (objects.length > 0) {
			oObject = (StatelessGuiSubitemTestObject) objects[0];
		}
		return oObject;
	}
	
	public StatelessGuiSubitemTestObject get3TabObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		StatelessGuiSubitemTestObject oObject = null;

		if (objects.length > 0) {
			oObject = (StatelessGuiSubitemTestObject) objects[0];
		}
		return oObject;
	}
		
	public ToggleGUITestObject getToggleGUITestObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		ToggleGUITestObject oObject = null;

		if (objects.length > 0) {
			oObject = (ToggleGUITestObject) objects[0];
		}
		return oObject;
	}
	
	public ToggleGUITestObject get2ToggleGUITestObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		ToggleGUITestObject oObject = null;

		if (objects.length > 0) {
			oObject = (ToggleGUITestObject) objects[1];
		}
		return oObject;
	}
	
	public ToggleGUITestObject get3ToggleGUITestObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		ToggleGUITestObject oObject = null;

		if (objects.length > 0) {
			oObject = (ToggleGUITestObject) objects[2];
		}
		return oObject;
	}
	
	public ToggleGUITestObject get4ToggleGUITestObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		ToggleGUITestObject oObject = null;

		if (objects.length > 0) {
			oObject = (ToggleGUITestObject) objects[3];
		}
		return oObject;
	}
	
	public ToggleGUITestObject get5ToggleGUITestObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		ToggleGUITestObject oObject = null;

		if (objects.length > 0) {
			oObject = (ToggleGUITestObject) objects[4];
		}
		return oObject;
	}
	
	public ToggleGUITestObject get6ToggleGUITestObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		ToggleGUITestObject oObject = null;

		if (objects.length > 0) {
			oObject = (ToggleGUITestObject) objects[5];
		}
		return oObject;
	}
	
	public ToggleGUITestObject get7ToggleGUITestObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		ToggleGUITestObject oObject = null;

		if (objects.length > 0) {
			oObject = (ToggleGUITestObject) objects[6];
		}
		return oObject;
	}
	
	public ToggleGUITestObject get8ToggleGUITestObject(String P1, String V1, String P2,
			String V2) {

		TestObject[] browsers = getRootTestObject().find(
				atProperty(".class", "Html.HtmlBrowser"));

		BrowserTestObject bBrowser = null;

		if (browsers.length > 0) {
			bBrowser = (BrowserTestObject) browsers[0];
		}

		TestObject[] objects = bBrowser.find(atDescendant(P1, V1, P2, V2));

		ToggleGUITestObject oObject = null;

		if (objects.length > 0) {
			oObject = (ToggleGUITestObject) objects[7];
		}
		return oObject;
	}

	public void MainPage() {
		callScript("Basic.MainPage");
	}

	public void FirstPage() {
		callScript("Basic.FirstPage");
	}

	public void Articles() {
		callScript("Basic.Articles");
	}

	public void Exhibitions() {
		callScript("Basic.Exhibitions");
	}

	public void Modles() {
		callScript("Basic.Modles");
	}

	public void Pages() {
		callScript("Basic.Pages");
	}
	
	public void Plugin() {
		callScript("Basic.Plugin");
	}
	
	public void User() {
		callScript("Basic.User");
	}
	
	public void E_Commerce() {
		callScript("Basic.E_Commerce");
	}

	public void Set() {
		callScript("Basic.Set");
	}

	// ���ݴ����windows�������ԣ����Ҷ�Ӧ��windows���󲢷��ء�����Ҳ����򷵻�null��

	public IWindow getWindow(String sCaption) {
		IWindow[] wins = RationalTestScript.getTopWindows();
		IWindow current = null;
		int length = wins.length;
		for (int i = 0; i < length; i++) {
			current = wins[i];
			if (current.getText().matches(sCaption)) {
				return current;
			}
		}
		return null;
	}

	// ���ݴ���Ĵ��ڶ�����Ӷ������� ���Ҳ������Ӷ���������Ҳ������򷵻�null��

	public IWindow getControl(IWindow iTopwin, String sCtrlText) {

		if (iTopwin == null) {
			System.out.println("�����windows����Ϊ��");
			return null;
		}

		// getChildren()�������ظö���������Ӷ�������顣

		IWindow[] windows = iTopwin.getChildren();
		IWindow current = null;
		int length = windows.length;
		for (int i = 0; i < length; i++) {
			current = windows[i];
			if (current.getText().contains(sCtrlText)) {
				return current;
			}
		}
		return null;
	}

	public IWindow getLevelWindow(String topWinName, String levelWinName) {

		IWindow winobjects = null;

		IWindow[] wins = RationalTestScript.getTopWindows();

		// ����windows��������

		for (int i = 0; i < wins.length; i++) {

			// �������в������з���topWinName���ԵĶ���

			if (wins[i].getText().equals(topWinName)) {

				winobjects = wins[i];

			}

		}

		IWindow[] winobj = winobjects.getChildren();

		for (int i = 0; i < winobj.length; i++) {

			if (winobj[i].getText().equals(levelWinName)) {

				// �ڶ��������,���ҷ���levelName���ԵĶ���

				return winobj[i];

			}

		}

		return null;

	}

	public IWindow getTopWindow(String objName) {

		IWindow[] wins = RationalTestScript.getTopWindows();

		int length = wins.length;

		for (int i = 0; i < length; i++) {

			if (wins[i].getText().matches(objName)) {

				return wins[i];

			}

		}

		return null;

	}

	public static void setNewLog() {
		try {
			// �������ڸ�ʽ
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(new Date());
			String filePath = "F:/zhangyu/workspace/Mylogs/TestResult" + date
					+ ".log";
			PrintStream ps = new PrintStream(filePath);

			System.setOut(ps);

		} catch (FileNotFoundException e) {
			// �쳣����
			e.printStackTrace();
		}
	}
	
	public static void setNowTime(){
	
			// �������ڸ�ʽ
			SimpleDateFormat NowTime = new SimpleDateFormat("yyyy-MM-dd H:m:s");

			String Time = NowTime.format(new Date())+"\r\n";
			
			AppendTestLog(Time);

	}

	public static void creatLogfile() {
		try {
			// PrintStream out =System.out;
			// �������ڸ�ʽ
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(new Date());
			String filePath1 = "F:/zhangyu/workspace/Mylogs/TestResult" + date
					+ ".log";
			File f = new File(filePath1);
			if (!f.exists()) {
				f.createNewFile();
			}
		} catch (FileNotFoundException e) {
			// �쳣����
			e.printStackTrace();
		} catch (IOException e) {
			// �쳣����
			e.printStackTrace();
		}
	}

	public static void fileChaseFOS(String filePath, String content) {
		try {
			// ���캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
			FileOutputStream fos = new FileOutputStream(filePath, true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			osw.write(content);
			osw.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("�ļ�д��ʧ�ܣ�" + e);
		}
	}
	
/*	public static TestObject findByXPath(TestObject testObject, String xPath) {
		List results;
		try {
			XPath xpath = new RFTXPath(xPath);
			results = xpath.selectNodes(testObject);
		} catch (JaxenException e) {
			throw new RuntimeException(xPath + " is not valid!", e);
		}

		if (results.size() == 0)
			throw new ObjectNotFoundException("Object is not found via "
					+ xPath);
		if (results.size() > 1)
			throw new AmbiguousRecognitionException(
					"Multiple object are found via " + xPath);
		Object obj = results.get(0);
		if (!(obj instanceof TestObject))
			throw new BadArgumentException("It's not TestObject found via "
					+ xPath);
		return (TestObject) obj;
	}*/

	public static void CreateTestLog(String content) {
		BufferedWriter bufferWritter = null;
		try {

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(new Date());
			String filePath = "F:/zhangyu/workspace/Mylogs/TestResult" + date
					+ ".log";
			File f = new File(filePath);
			if (f.exists()) {
				f.delete();
			}
			else{
				f.createNewFile();
			};

			// true = append file
			FileWriter fileWritter = new FileWriter(f, true);
			bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.append(content);

			bufferWritter.flush();
			fileWritter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferWritter != null) {
				try {
					bufferWritter.close();
				} catch (IOException e) {
					// TODO �Զ����� catch ��
					e.printStackTrace();
				}
			}
		}

	}
	
	public static void AppendTestLog(String content) {
		BufferedWriter bufferWritter = null;
		try {

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(new Date());
			String filePath = "F:/zhangyu/workspace/Mylogs/TestResult" + date
					+ ".log";
			File f = new File(filePath);
			if (!f.exists()) {
				f.createNewFile();
			}
			// true = append file
			FileWriter fileWritter = new FileWriter(f, true);
			bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.append(content);

			bufferWritter.flush();
			fileWritter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferWritter != null) {
				try {
					bufferWritter.close();
				} catch (IOException e) {
					// TODO �Զ����� catch ��
					e.printStackTrace();
				}
			}
		}

	}
	
	/*public static GuiTestObject findGuiByXPath(GuiTestObject testObject, String xPath) {
		List results;
		try {
			XPath xpath = new RFTXPath(xPath);
			results = xpath.selectNodes(testObject);
		} catch (JaxenException e) {
			throw new RuntimeException(xPath + " is not valid!", e);
		}

		if (results.size() == 0)
			throw new ObjectNotFoundException("Object is not found via "
					+ xPath);
		if (results.size() > 1)
			throw new AmbiguousRecognitionException(
					"Multiple object are found via " + xPath);
		Object obj = results.get(0);
		//GuiTestObject obj = (GuiTestObject) results.get(0);
		
		if (!(obj instanceof GuiTestObject))
			throw new BadArgumentException("It's not GuiTestObject found via "
					+ xPath);
		return (GuiTestObject) obj;
	}*/
	
	
	public static void AutoTestLogMail() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(new Date());
	//	SendMail LogMail = new SendMail();
		// ���÷����˵�ַ���ռ��˵�ַ���ʼ�����
		//LogMail.setAddress("jiang.x@vcooline.com", "17152879@qq.com", "�Զ���������־");
	//	LogMail.setAddress("zhang.yu@vcooline.com", "1249138705@qq.com", "�Զ���������־");
		//LogMail.setAddress("zhang.yu@vcooline.com", "110494805@qq.com", "�Զ���������־");
		// ����Ҫ���͸�����λ�úͱ���
	//	LogMail.setAffix("F:/zhangyu/workspace/Mylogs/TestResult" + date
	//				+ ".log", "��־�嵥");
		//LogMail.setAffix("F:/zhangyu/workspace/YeahSite_logs/Pages.PagesAllSuites/rational_ft_log.html","��־����");
		// ����smtp�������Լ�����������ʺź�����
	//	LogMail.send("smtp.exmail.qq.com", "zhang.yu@vcooline.com", "wkl.123456");
	}
	

	
}
