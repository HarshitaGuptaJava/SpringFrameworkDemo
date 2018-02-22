package com.devopsbuddy.web.controllers;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.web.domain.frontend.FeedbackPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    private static final Logger LOG= LoggerFactory.getLogger(ContactController.class);
    private static final String CONTACTUS_VIEW_NAME = "contact/contact";

    private static final String FEEDBACK_MODEL_KEY = "feedback";

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/contact",method = RequestMethod.GET)
    public String contactGet(ModelMap modelMap)
    {
        FeedbackPojo feedbackPojo=new FeedbackPojo();
        modelMap.addAttribute(ContactController.FEEDBACK_MODEL_KEY,feedbackPojo);

        return ContactController.CONTACTUS_VIEW_NAME;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedbackPojo feedbackPojo)
    {

        LOG.debug("feedback POJO Content :" + feedbackPojo);
        emailService.sendFeedbackEmail(feedbackPojo);
        return ContactController.CONTACTUS_VIEW_NAME;
    }
}
