/*
 * @(#)Type.java 2014-1-10 ����11:25:32 Survey
 */
package com.survey.model;

/**
 * Type
 * @author wang
 * @version 1.0
 *
 */
public enum Type {
    ONE, MANY, TEXT;

    public String toString() {
        switch (this) {
            case ONE:
                return "��ѡ��";
            case MANY:
                return "��ѡ��";
            case TEXT:
                return "�ʴ���";
        }
        return null;
    }
}