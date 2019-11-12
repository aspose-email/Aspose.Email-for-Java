package com.aspose.email.examples.email;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

import java.util.Date;

/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

public class WorkingWithAmpHtmlEmails {
    public static void main(String[] args) {
        // ExStart:1
        String dataDir = Utils.getSharedDataDir(CustomHyperlinkRendering.class) + "OutputDirectory/";

        AmpMessage msg = new AmpMessage();
        msg.setHtmlBody("<html><body> Hello AMP </body></html>");

        //add AmpAnim component
        AmpAnim anim = new AmpAnim(800, 400);
        anim.setSrc("https://placekitten.com/800/400");
        anim.setAlt("Test alt");
        anim.setAttribution("The Go gopher was designed by Reneee French");
        anim.getAttributes().setLayout(LayoutType.Responsive);
        anim.setFallback("offline");
        msg.addAmpComponent(anim);

        //add AmpImage component
        AmpImage img = new AmpImage(800, 400);
        img.setSrc("https://placekitten.com/800/400");
        img.setAlt("Test alt");
        img.getAttributes().setLayout(LayoutType.Responsive);
        msg.addAmpComponent(img);

        //add AmpCarousel component
        AmpCarousel car = new AmpCarousel(800, 400);
        img = new AmpImage(800, 400);
        img.setSrc("https://amp.dev/static/img/docs/tutorials/firstemail/photo_by_caleb_woods.jpg");
        img.setAlt("Test 2 alt");
        img.getAttributes().setLayout(LayoutType.Fixed);
        car.getImages().add(img);
        img = new AmpImage(800, 400);
        img.setSrc("https://placekitten.com/800/400");
        img.setAlt("Test alt");
        img.getAttributes().setLayout(LayoutType.Responsive);
        car.getImages().add(img);
        img = new AmpImage(800, 400);
        img.setSrc("https://amp.dev/static/img/docs/tutorials/firstemail/photo_by_craig_mclaclan.jpg");
        img.setAlt("Test 3 alt");
        img.getAttributes().setLayout(LayoutType.Fill);
        car.getImages().add(img);
        msg.addAmpComponent(car);

        //add AmpFitText component
        AmpFitText txt = new AmpFitText("Lorem ipsum dolor sit amet, has nisl nihil convenire et, vim at aeque inermis reprehendunt.");
        txt.getAttributes().setWidth(600);
        txt.getAttributes().setHeight(300);
        txt.getAttributes().setLayout(LayoutType.Responsive);
        txt.setMinFontSize(8);
        txt.setMaxFontSize(16);
        txt.setValue("Lorem ipsum dolor sit amet, has nisl nihil convenire et, vim at aeque inermis reprehendunt.");
        msg.addAmpComponent(txt);

        //add AmpAccordion component
        AmpAccordion acc = new AmpAccordion();
        acc.setExpandSingleSection(true);

        Section sec = new Section();
        sec.setHeader(new SectionHeader(SectionHeaderType.h2, "Section 1"));
        sec.setValue(new SectionValue("Content in section 1."));
        acc.getSections().add(sec);

        sec = new Section();
        sec.setHeader(new SectionHeader(SectionHeaderType.h2, "Section 2"));
        sec.setValue(new SectionValue("Content in section 2."));
        acc.getSections().add(sec);

        img = new AmpImage(800, 400);
        img.setSrc("https://placekitten.com/800/400");
        img.setAlt("Test alt");
        img.getAttributes().setLayout(LayoutType.Responsive);

        sec = new Section();
        sec.setHeader(new SectionHeader(SectionHeaderType.h2, "Section 3"));
        sec.setValue(new SectionValue(img));
        acc.getSections().add(sec);
        msg.addAmpComponent(acc);

        //add AmpForm component
        AmpForm form = new AmpForm();

        form.setMethod(FormMethod.Post);
        form.setActionXhr("https://example.com/subscribe");
        form.setTarget(FormTarget.Top);

        FormField field = new FormField("Name:", "text");
        field.setName("name");
        field.setRequired(true);
        form.getFieldset().add(field);

        field = new FormField("Email:", "email");
        field.setName("email");
        field.setRequired(true);
        form.getFieldset().add(field);

        field = new FormField();
        field.setInputType("submit");
        field.setValue("Subscribe");
        form.getFieldset().add(field);
        msg.addAmpComponent(form);

        msg.save(dataDir + "AmpTest_1.eml");
        MailMessage savedmsg = MailMessage.load(dataDir + "AmpTest_1.eml");
        AmpMessage ampMsg = (AmpMessage)savedmsg;
        if(ampMsg != null)
        {
            Date dt = new Date();
            AmpTimeago time = new AmpTimeago(dt);
            time.getAttributes().setWidth(600);
            time.getAttributes().setHeight(300);
            time.getAttributes().setLayout(LayoutType.Fixed);
            time.setLocale("en-US");
            time.setCutoff(600);
            ampMsg.addAmpComponent(time);

            ampMsg.save(dataDir + "AmpTest_2.eml");
        }
        // ExEnd:1
    }
}

