package com.ssafy.edu.service.block;

import com.ssafy.edu.model.block.*;
import com.ssafy.edu.model.user.User;
import com.ssafy.edu.repository.BlockJpaRepository;
import com.ssafy.edu.repository.BlockUsersJpaRepository;
import com.ssafy.edu.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private BlockJpaRepository blockJpaRepository;

    @Autowired
    private BlockUsersJpaRepository blockUsersJpaRepository;

    @Override
    public ResponseEntity<BlockResponse> getBlockList(String email) {

        BlockResponse result = new BlockResponse();
        List<Block> blockList = blockJpaRepository.findAll();

        BlockCategoryResult resultList = new BlockCategoryResult();
        Optional<User> userOpt = userJpaRepository.findByEmail(email);
        List<BlockUsers> blockUsersList = userOpt.get().getBlockUsersList();

        if (!blockList.isEmpty()) {

            List<BlockResult> calculationList = new ArrayList<>();
            List<BlockResult> flowList = new ArrayList<>();
            List<BlockResult> functionList = new ArrayList<>();
            List<BlockResult> judgementList = new ArrayList<>();
            List<BlockResult> movementList = new ArrayList<>();
            List<BlockResult> startList = new ArrayList<>();


            for (Block b : blockList) {

                BlockResult blockResult = new BlockResult();

                switch (b.getCategory()) {
                    case "calculation":
                        blockResult.setId(b.getId());
                        blockResult.setPrice(b.getPrice());
                        blockResult.setUserHave(false);
                        blockResult.setCategory("??????");
                        for(BlockUsers blockUsers : blockUsersList){
                            if (blockUsers.getBlock().equals(b)){
                                blockResult.setUserHave(true);
                            }
                        }
                        calculationList.add(blockResult);
                        break;
                    case "flow":
                        blockResult.setId(b.getId());
                        blockResult.setPrice(b.getPrice());
                        blockResult.setUserHave(false);
                        blockResult.setCategory("??????");
                        for(BlockUsers blockUsers : blockUsersList){
                            if (blockUsers.getBlock().equals(b)){
                                blockResult.setUserHave(true);
                            }
                        }
                        flowList.add(blockResult);
                        break;
                    case "function":
                        blockResult.setId(b.getId());
                        blockResult.setPrice(b.getPrice());
                        blockResult.setUserHave(false);
                        blockResult.setCategory("??????");
                        for(BlockUsers blockUsers : blockUsersList){
                            if (blockUsers.getBlock().equals(b)){
                                blockResult.setUserHave(true);
                            }
                        }
                        functionList.add(blockResult);
                        break;
                    case "judgement":
                        blockResult.setId(b.getId());
                        blockResult.setPrice(b.getPrice());
                        blockResult.setUserHave(false);
                        blockResult.setCategory("??????");
                        for(BlockUsers blockUsers : blockUsersList){
                            if (blockUsers.getBlock().equals(b)){
                                blockResult.setUserHave(true);
                            }
                        }
                        judgementList.add(blockResult);
                        break;
                    case "movement":
                        blockResult.setId(b.getId());
                        blockResult.setPrice(b.getPrice());
                        blockResult.setUserHave(false);
                        blockResult.setCategory("?????????");
                        for(BlockUsers blockUsers : blockUsersList){
                            if (blockUsers.getBlock().equals(b)){
                                blockResult.setUserHave(true);
                            }
                        }
                        movementList.add(blockResult);
                        break;
                    case "start":
                        blockResult.setId(b.getId());
                        blockResult.setPrice(b.getPrice());
                        blockResult.setUserHave(false);
                        blockResult.setCategory("??????");
                        for(BlockUsers blockUsers : blockUsersList){
                            if (blockUsers.getBlock().equals(b)){
                                blockResult.setUserHave(true);
                            }
                        }
                        startList.add(blockResult);
                        break;
                }
            }
            resultList.set??????(calculationList);
            resultList.set??????(flowList);
            resultList.set??????(functionList);
            resultList.set??????(judgementList);
            resultList.set?????????(movementList);
            resultList.set??????(startList);


            result.status = true;
            result.data = resultList;

        } else {
            result.status = false;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /* ?????? ????????? ?????? ?????? ?????? */
    @Override
    public ResponseEntity<BlockResponse> getMyBlockList(String email) {

        BlockResponse result = new BlockResponse();

        // ????????? ??????
        Optional<User> userOpt = userJpaRepository.findByEmail(email);
        if (userOpt.isPresent()) {

            List<BlockUsers> blockUsersList = userOpt.get().getBlockUsersList();
            BlockMyResult blockMyResult = new BlockMyResult();

            BlockMyResponse start = new BlockMyResponse();
            BlockMyResponse judgement = new BlockMyResponse();
            BlockMyResponse movement = new BlockMyResponse();
            BlockMyResponse flow = new BlockMyResponse();
            BlockMyResponse calculation = new BlockMyResponse();
            BlockMyResponse function = new BlockMyResponse();

            start.setName("??????");
            start.setColour("#C30D23");
            judgement.setName("??????");
            judgement.setColour("#FFA31D");
            movement.setName("?????????");
            movement.setColour("#8FC31F");
            flow.setName("??????");
            flow.setColour("#55CFFF");
            calculation.setName("??????");
            calculation.setColour("#1060FF");
            function.setName("??????");
            function.setColour("#CC6666");

            List<BlockType> startblock = new ArrayList<>();
            List<BlockType> judgeblock = new ArrayList<>();
            List<BlockType> moveblock = new ArrayList<>();
            List<BlockType> flowblock = new ArrayList<>();
            List<BlockType> calculblock = new ArrayList<>();
            List<BlockType> funcblock = new ArrayList<>();

            if (!blockUsersList.isEmpty()) {
                for (BlockUsers blockUsers : blockUsersList) {
                    switch (blockUsers.getBlock().getCategory()){
                        case "start":
                            BlockType tmp1 = new BlockType();
                            tmp1.setType(blockUsers.getBlock().getName());
                            startblock.add(tmp1);
                            break;
                        case "judgement":
                            BlockType tmp2 = new BlockType();
                            tmp2.setType(blockUsers.getBlock().getName());
                            judgeblock.add(tmp2);
                            break;
                        case "movement":
                            BlockType tmp3 = new BlockType();
                            tmp3.setType(blockUsers.getBlock().getName());
                            moveblock.add(tmp3);
                            break;
                        case "flow":
                            BlockType tmp4 = new BlockType();
                            tmp4.setType(blockUsers.getBlock().getName());
                            flowblock.add(tmp4);
                            break;
                        case "calculation":
                            BlockType tmp5 = new BlockType();
                            tmp5.setType(blockUsers.getBlock().getName());
                            calculblock.add(tmp5);
                            break;
                        case "function":
                            BlockType tmp7 = new BlockType();
                            tmp7.setType(blockUsers.getBlock().getName());
                            funcblock.add(tmp7);
                            break;
                    }
                }
            }

            start.setBlocks(startblock);
            judgement.setBlocks(judgeblock);
            movement.setBlocks(moveblock);
            flow.setBlocks(flowblock);
            calculation.setBlocks(calculblock);
            function.setBlocks(funcblock);

            blockMyResult.setStart(start);
            blockMyResult.setJudgement(judgement);
            blockMyResult.setMovement(movement);
            blockMyResult.setFlow(flow);
            blockMyResult.setCalculation(calculation);
            blockMyResult.setFunction(function);

            result.status = true;
            result.data = blockMyResult;
            return new ResponseEntity<>(result, HttpStatus.OK);

        }

        result.status = false;
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<BlockResponse> signUpBlocks(BlocksignUpTest blocksignUpTest) {
        BlockResponse result = new BlockResponse();

       Block block = new Block().builder()
               .category(blocksignUpTest.getCategory())
               .name(blocksignUpTest.getName())
               .price(blocksignUpTest.getPrice())
               .build();
       Block blockResult =  blockJpaRepository.save(block);

        result.status = true;
        result.data = blockResult;
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
