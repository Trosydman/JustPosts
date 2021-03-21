package com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.mapper

import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.MockClientResponse
import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.MockClientResponse.Data1Index
import com.cmesquita.technicaltest.justposts.ui.model.MockUiModels
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class Data1DTOMapperTest {

    lateinit var data1DTOMapper: Data1DTOMapper

    @Before
    fun setUp() {
        data1DTOMapper = Data1DTOMapper()
    }

    @Test
    fun mappingDefaultData1_shouldReturnDefaultPost() {
        val defaultData1 = getData1By(Data1Index.DEFAULT.ordinal)
        val expectedUiPost = getUiPostBy(MockUiModels.PostIndex.DEFAULT.ordinal)

        val mappedUiPost = data1DTOMapper.mapToDomainModel(defaultData1)

        assertTrue(mappedUiPost == expectedUiPost)
    }

    @Test
    fun mappingNoTitleData1_shouldReturnNoTitlePost() {
        val data1 = getData1By(Data1Index.NO_TITLE.ordinal)
        val expectedUiPost = getUiPostBy(MockUiModels.PostIndex.NO_TITLE.ordinal)

        val mappedUiPost = data1DTOMapper.mapToDomainModel(data1)

        assertTrue(mappedUiPost == expectedUiPost)
    }

    @Test
    fun mappingNoBodyData1_shouldReturnNoBodyPost() {
        val data1 = getData1By(Data1Index.NO_BODY.ordinal)
        val expectedUiPost = getUiPostBy(MockUiModels.PostIndex.NO_BODY.ordinal)

        val mappedUiPost = data1DTOMapper.mapToDomainModel(data1)

        assertTrue(mappedUiPost == expectedUiPost)
    }

    @Test
    fun mappingNoUsersNameData1_shouldReturnNoUsersNamePost() {
        val data1 = getData1By(Data1Index.NO_USER_NAME.ordinal)
        val expectedUiPost = getUiPostBy(MockUiModels.PostIndex.NO_USER_NAME.ordinal)

        val mappedUiPost = data1DTOMapper.mapToDomainModel(data1)

        assertTrue(mappedUiPost == expectedUiPost)
    }

    @Test
    fun mappingNoUsersUsernameData1_shouldReturnNoUsersUsernamePost() {
        val data1 = getData1By(Data1Index.NO_USER_USERNAME.ordinal)
        val expectedUiPost = getUiPostBy(MockUiModels.PostIndex.NO_USER_USERNAME.ordinal)

        val mappedUiPost = data1DTOMapper.mapToDomainModel(data1)

        assertTrue(mappedUiPost == expectedUiPost)
    }

    @Test
    fun mappingNoUserData1_shouldReturnNoUserPost() {
        val data1 = getData1By(Data1Index.NO_USER.ordinal)
        val expectedUiPost = getUiPostBy(MockUiModels.PostIndex.NO_USER.ordinal)

        val mappedUiPost = data1DTOMapper.mapToDomainModel(data1)

        assertTrue(mappedUiPost == expectedUiPost)
    }

    @Test
    fun mappingNoTitleAndBodyData1_shouldReturnNull() {
        val data1 = getData1By(Data1Index.NO_TITLE_AND_BODY.ordinal)

        val mappedUiPost = data1DTOMapper.mapToDomainModel(data1)

        assertNull(mappedUiPost)
    }

    @Test
    fun mappingEmptyTitleAndBodyData1_shouldReturnNull() {
        val data1 = getData1By(Data1Index.EMPTY_TITLE_AND_BODY.ordinal)

        val mappedUiPost = data1DTOMapper.mapToDomainModel(data1)

        assertNull(mappedUiPost)
    }

    @Test
    fun mappingBlankTitleAndBodyData1_shouldReturnNull() {
        val data1 = getData1By(Data1Index.BLANK_TITLE_AND_BODY.ordinal)

        val mappedUiPost = data1DTOMapper.mapToDomainModel(data1)

        assertNull(mappedUiPost)
    }

    @Test
    fun mappingData1List_shouldReturnLessPosts() {
        val data1List = MockClientResponse.fakeDefaultData1List
        val expectedPostLists = MockUiModels.fakeDefaultUiPostList

        val mappedUiPostList = data1DTOMapper.mapToDomainModelList(data1List)

        assert(mappedUiPostList.size == expectedPostLists.size)
    }

    private fun getData1By(data1Index: Int) =
        MockClientResponse.fakeDefaultClientResponse.data!![data1Index]

    private fun getUiPostBy(postUiIndex: Int) = MockUiModels.fakeDefaultUiPostList[postUiIndex]
}
