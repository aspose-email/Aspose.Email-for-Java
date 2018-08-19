package com.aspose.email.examples.outlook.msg;

import com.aspose.email.MapiMessage;
import com.aspose.email.MhtFormatOptions;
import com.aspose.email.MhtSaveOptions;
import com.aspose.email.MhtTemplateName;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;

public class ConvertMapiTaskToMHT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ExStart: convertMapiTaskToMHT
		String dataDir = Utils.getSharedDataDir(CreateAndSaveOutlookMessageFile.class) + "outlook/";
		
		MapiMessage msg = MapiMessage.fromFile(dataDir + "MapiTask.msg");
		MhtSaveOptions opt = SaveOptions.getDefaultMhtml();
		opt.setMhtFormatOptions(MhtFormatOptions.RenderTaskFields | MhtFormatOptions.WriteHeader);

		opt.getFormatTemplates().clear();
		opt.getFormatTemplates().add(MhtTemplateName.Task.SUBJECT, "<span class='headerLineTitle'>Subject:</span><span class='headerLineText'>{0}</span><br/>");
		opt.getFormatTemplates().add(MhtTemplateName.Task.ACTUAL_WORK, "<span class='headerLineTitle'>Actual Work:</span><span class='headerLineText'>{0}</span><br/>");
		opt.getFormatTemplates().add(MhtTemplateName.Task.TOTAL_WORK, "<span class='headerLineTitle'>Total Work:</span><span class='headerLineText'>{0}</span><br/>");
		opt.getFormatTemplates().add(MhtTemplateName.Task.STATUS, "<span class='headerLineTitle'>Status:</span><span class='headerLineText'>{0}</span><br/>");
		opt.getFormatTemplates().add(MhtTemplateName.Task.OWNER, "<span class='headerLineTitle'>Owner:</span><span class='headerLineText'>{0}</span><br/>");
		opt.getFormatTemplates().add(MhtTemplateName.Task.PRIORITY, "<span class='headerLineTitle'>Priority:</span><span class='headerLineText'>{0}</span><br/>");

		msg.save(dataDir + "MapiTask_out.mht", opt);
		//ExEnd: convertMapiTaskToMHT
	}
}
