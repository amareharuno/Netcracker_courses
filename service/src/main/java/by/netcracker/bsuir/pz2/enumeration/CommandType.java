package by.netcracker.bsuir.pz2.enumeration;

import by.netcracker.bsuir.pz2.command.Command;
import by.netcracker.bsuir.pz2.command.common.EmptyCommand;
import by.netcracker.bsuir.pz2.command.common.SignInCommand;
import by.netcracker.bsuir.pz2.command.common.SignUpCommand;

public enum CommandType {
    // Common commands
    EMPTY {
        @Override
        public Command getCommandOfThisType() {
            return new EmptyCommand();
        }
    },
    LOGIN {
        @Override
        public Command getCommandOfThisType() {
            return new SignInCommand();
        }
    },
    REGISTER {
        @Override
        public Command getCommandOfThisType() {
            return new SignUpCommand();
        }
    };
    /*,
    SUBMIT_LOGIN {

    },
    SUBMIT_REGISTRATION {

    },
    ENTER {

    },
    LOGOUT {

    },

    // by.netcracker.bsuir.pz2.command.Student's commands
    STUDENT_ADD_COURSE {},
    STUDENT_START_COURSE {},
    STUDENT_SHOW_COURSE_INFO {},
    BACK_TO_STUDENT_PROFILE {},
    STUDENT_BACK_TO_COURSE_LIST {},

    // by.netcracker.bsuir.pz2.command.Teacher's commands
    TEACHER_CREATE_COURSE {},
    TEACHER_SUBMIT_COURSE_CREATION {},
    BACK_TO_TEACHER_PROFILE {}*/

    public abstract Command getCommandOfThisType();
}
