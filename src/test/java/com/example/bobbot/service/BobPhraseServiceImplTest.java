package com.example.bobbot.service;

import com.example.bobbot.entity.BobPhrase;
import com.example.bobbot.repository.BobPhraseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class BobPhraseServiceImplTest {

    @Mock
    private BobPhraseRepository bobPhraseRepository;

    @InjectMocks
    BobPhraseServiceImpl bobPhraseServiceImpl;

    @Test
    void getBobPhrasesByTag_SingleResult() {
        BobPhrase expectedResult = new BobPhrase();
        final String TAG = "start";

        expectedResult.setId(1);
        expectedResult.setTag(TAG);
        expectedResult.setPhrase("Привет");

        doReturn(expectedResult).when(bobPhraseRepository).findBobPhraseByTag(Mockito.anyString());
        BobPhrase actualResult = bobPhraseServiceImpl.getBobPhrasesByTag(TAG);
        verify(bobPhraseRepository, times(1)).findBobPhraseByTag(TAG);
        assertEquals(expectedResult,actualResult);
    }

}